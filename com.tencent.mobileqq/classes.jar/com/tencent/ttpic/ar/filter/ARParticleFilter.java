package com.tencent.ttpic.ar.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
import com.tencent.filter.Param.TextureParam;
import com.tencent.oscarcamera.particlesystem.FrameParticleData;
import com.tencent.oscarcamera.particlesystem.ParticleSystemEx;
import com.tencent.oscarcamera.particlesystem.Sprite;
import com.tencent.ttpic.QQLogUtils;
import com.tencent.ttpic.ar.util.ARMatrixUtil;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.Point3D;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ARParticleFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER_COMMON = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleFragmentShader.dat");
  private static final String VERTEX_SHADER_COMMON = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleVertexShader.dat");
  private String TAG = ARParticleFilter.class.getSimpleName();
  private float far = 2000.0F;
  private FrameData[] frameDataBufferQueue = new FrameData[2];
  private int frameDataBufferQueueIndex = 0;
  private float mCanvasHeight;
  private float mCanvasWidth;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame = new Frame();
  private Frame mInputFrame;
  private FrameData mLastFrameData;
  private ParticleCalculationHandler mParticleCalculationHandler;
  private List<String> mParticleDirList;
  private ParticleSystemEx mParticleSystem = new ParticleSystemEx(VideoGlobalContext.getContext());
  private Map<String, Integer> mPathToBitmapIndexMapping = new HashMap();
  private Map<String, AudioUtils.Player> mPlayerMapping = new HashMap();
  private List<Sprite> mSpriteList;
  private List<ArrayList<TexCoord>> mTexCoords = new ArrayList();
  private Bitmap[] mTextureBitmaps;
  private Size[] mTextureSizes;
  private int[] mTextures;
  private float mViewDistance;
  private float near = 100.0F;
  private BitmapDecodeTask task;
  
  public ARParticleFilter(List<String> paramList, String paramString)
  {
    super(VERTEX_SHADER_COMMON, FRAGMENT_SHADER_COMMON, new StickerItem());
    this.dataPath = paramString;
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    initParticle(paramList);
  }
  
  private void calTexCoordList(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    if (paramInt1 < this.mTexCoords.size())
    {
      Object localObject = (ArrayList)this.mTexCoords.get(paramInt1);
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ((ArrayList)localObject).size()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      if (paramInt1 < ((ArrayList)localObject).size())
      {
        localObject = (TexCoord)((ArrayList)localObject).get(paramInt1);
        paramInt2 = 0;
        paramInt1 = paramInt3 * 12;
        while ((paramInt2 < 12) && (paramInt1 < paramArrayOfFloat.length))
        {
          paramArrayOfFloat[paramInt1] = localObject.texCoord[paramInt2];
          paramInt2 += 1;
          paramInt1 += 1;
        }
      }
    }
  }
  
  private boolean changeTexture(String paramString)
  {
    if (!this.mPathToBitmapIndexMapping.containsKey(paramString)) {}
    int i;
    do
    {
      return false;
      i = ((Integer)this.mPathToBitmapIndexMapping.get(paramString)).intValue();
      if (this.mTextures[i] != 0) {
        break;
      }
      paramString = this.mTextureBitmaps[i];
    } while (!isBitmapLegal(paramString));
    this.mTextureSizes[i] = new Size(paramString.getWidth(), paramString.getHeight());
    GLES20.glGenTextures(1, this.mTextures, i);
    GLES20.glBindTexture(3553, this.mTextures[i]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    for (;;)
    {
      try
      {
        GLUtils.texImage2D(3553, 0, paramString, 0);
        paramString.recycle();
        paramString = new Param.TextureParam("inputImageTexture2", this.mTextures[i], 33986);
        paramString.initialParams(getmProgramIds());
        addParam(paramString);
        if ((this.mTextureSizes[i] != null) && (this.mTextureSizes[i].isValid()))
        {
          bool = true;
          return bool;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        return false;
      }
      boolean bool = false;
    }
  }
  
  private void initParticle(List<String> paramList)
  {
    if (paramList != null)
    {
      this.mParticleDirList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        this.mParticleDirList.add(((String)paramList.get(i)).substring(0, ((String)paramList.get(i)).lastIndexOf("/")));
        paramList.set(i, VideoUtil.getRealPath(this.dataPath + File.separator + (String)paramList.get(i)));
        i += 1;
      }
      this.mParticleSystem.loadParticleData(paramList);
      this.mSpriteList = this.mParticleSystem.getSprites();
      this.mTextureBitmaps = new Bitmap[this.mSpriteList.size()];
      this.mTextures = new int[this.mSpriteList.size()];
      this.mTextureSizes = new Size[this.mSpriteList.size()];
      i = 0;
      while ((i < this.mSpriteList.size()) && (i < this.mParticleDirList.size()))
      {
        this.mPathToBitmapIndexMapping.put((String)this.mParticleDirList.get(i) + File.separator + ((Sprite)this.mSpriteList.get(i)).path, Integer.valueOf(i));
        this.mTexCoords.add(new ArrayList());
        i += 1;
      }
      this.task = new BitmapDecodeTask();
      this.task.execute(new Void[0]);
    }
    paramList = new HandlerThread("ParticleCalculationThread", -16);
    paramList.start();
    this.mParticleCalculationHandler = new ParticleCalculationHandler(paramList.getLooper());
    this.mParticleCalculationHandler.sendEmptyMessage(0);
  }
  
  private boolean isBitmapLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private void playMusicIfNeeded(FrameData paramFrameData)
  {
    if (paramFrameData.needPlayMusic)
    {
      Iterator localIterator = paramFrameData.frameParticleData.iterator();
      while (localIterator.hasNext())
      {
        paramFrameData = (FrameParticleData)localIterator.next();
        if (!TextUtils.isEmpty(paramFrameData.audioPath))
        {
          String str = paramFrameData.audioPath;
          if (!this.mPlayerMapping.containsKey(str)) {
            if (!str.startsWith("assets://")) {
              break label130;
            }
          }
          label130:
          for (paramFrameData = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);; paramFrameData = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), str, false))
          {
            this.mPlayerMapping.put(str, paramFrameData);
            paramFrameData = (AudioUtils.Player)this.mPlayerMapping.get(str);
            if (paramFrameData == null) {
              break;
            }
            AudioUtils.startPlayer(paramFrameData, true);
            break;
          }
        }
      }
    }
  }
  
  private float pow2(float paramFloat)
  {
    return paramFloat * paramFloat;
  }
  
  private void vectorNormalization(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3)) {}
    float f;
    do
    {
      return;
      f = (float)Math.sqrt(pow2(paramArrayOfFloat[0]) + pow2(paramArrayOfFloat[1]) + pow2(paramArrayOfFloat[2]));
    } while (f <= 0.0F);
    paramArrayOfFloat[0] /= f;
    paramArrayOfFloat[1] /= f;
    paramArrayOfFloat[2] /= f;
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    float f1 = ARMatrixUtil.nearRectHeight / ARMatrixUtil.nearRectWidth;
    float f2 = ARMatrixUtil.nearRectWidth;
    float f3 = this.mViewDistance / ARMatrixUtil.near;
    float f4 = ARMatrixUtil.nearRectHeight;
    float f5 = this.mViewDistance / ARMatrixUtil.near;
    Object localObject2 = new Point3D();
    ((Point3D)localObject2).x = (this.mViewDistance * ARMatrixUtil.cameraX);
    ((Point3D)localObject2).y = (this.mViewDistance * ARMatrixUtil.cameraY);
    ((Point3D)localObject2).z = (this.mViewDistance * ARMatrixUtil.cameraZ);
    Object localObject1 = new float[3];
    localObject1[0] = (ARMatrixUtil.cameraUpX * f1 + ARMatrixUtil.cameraRightX);
    localObject1[1] = (ARMatrixUtil.cameraUpY * f1 + ARMatrixUtil.cameraRightY);
    localObject1[2] = (ARMatrixUtil.cameraUpZ * f1 + ARMatrixUtil.cameraRightZ);
    vectorNormalization((float[])localObject1);
    f2 = (float)Math.sqrt(pow2(f2 * f3) + pow2(f4 * f5)) / 2.0F;
    Point3D localPoint3D1 = new Point3D();
    localPoint3D1.x = (((Point3D)localObject2).x - localObject1[0] * f2);
    localPoint3D1.y = (((Point3D)localObject2).y - localObject1[1] * f2);
    localPoint3D1.z = (((Point3D)localObject2).z - localObject1[2] * f2);
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = (ARMatrixUtil.cameraUpX * f1 - ARMatrixUtil.cameraRightX);
    arrayOfFloat[1] = (ARMatrixUtil.cameraUpY * f1 - ARMatrixUtil.cameraRightY);
    arrayOfFloat[2] = (ARMatrixUtil.cameraUpZ * f1 - ARMatrixUtil.cameraRightZ);
    vectorNormalization(arrayOfFloat);
    localObject1 = new Point3D();
    ((Point3D)localObject2).x += arrayOfFloat[0] * f2;
    ((Point3D)localObject2).y += arrayOfFloat[1] * f2;
    ((Point3D)localObject2).z += arrayOfFloat[2] * f2;
    Point3D localPoint3D2 = new Point3D();
    localPoint3D2.x = (((Point3D)localObject2).x - arrayOfFloat[0] * f2);
    localPoint3D2.y = (((Point3D)localObject2).y - arrayOfFloat[1] * f2);
    localPoint3D2.z = (((Point3D)localObject2).z - arrayOfFloat[2] * f2);
    f2 = paramPointF.x / this.width;
    f1 = f2;
    if (ARMatrixUtil.isFrontCamera) {
      f1 = 1.0F - f2;
    }
    localObject2 = new float[3];
    localObject2[0] = ((localPoint3D2.x - localPoint3D1.x) * f1);
    localObject2[1] = ((localPoint3D2.y - localPoint3D1.y) * f1);
    localObject2[2] = ((localPoint3D2.z - localPoint3D1.z) * f1);
    f1 = 1.0F - paramPointF.y / this.height;
    paramPointF = new float[3];
    paramPointF[0] = ((((Point3D)localObject1).x - localPoint3D1.x) * f1);
    paramPointF[1] = ((((Point3D)localObject1).y - localPoint3D1.y) * f1);
    paramPointF[2] = ((((Point3D)localObject1).z - localPoint3D1.z) * f1);
    localObject1 = new Point3D();
    ((Point3D)localObject1).x = (localPoint3D1.x + localObject2[0] + paramPointF[0]);
    ((Point3D)localObject1).y = (localPoint3D1.y + localObject2[1] + paramPointF[1]);
    ((Point3D)localObject1).z = (localPoint3D1.z + localObject2[2] + paramPointF[2]);
    this.mParticleSystem.emitImmediately(((Point3D)localObject1).x, ((Point3D)localObject1).y, ((Point3D)localObject1).z);
  }
  
  public void clear()
  {
    ClearGLSL();
    ARMatrixUtil.stopOrientationSensor();
    Bitmap[] arrayOfBitmap = this.mTextureBitmaps;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (isBitmapLegal(localBitmap)) {
        localBitmap.recycle();
      }
      i += 1;
    }
    if (this.task != null) {
      this.task.cancel(true);
    }
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
    this.mCopyFilter.ClearGLSL();
    this.mCopyFrame.clear();
    destroyAudioPlayer();
    this.mParticleSystem.release();
    System.gc();
  }
  
  public void destroyAudioPlayer()
  {
    Iterator localIterator = this.mPlayerMapping.values().iterator();
    while (localIterator.hasNext()) {
      AudioUtils.destroyPlayer((AudioUtils.Player)localIterator.next());
    }
    this.mPlayerMapping.clear();
  }
  
  public void initAttribParams()
  {
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("positionIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("particleCenter", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
    addAttribParam(new AttributeParam("particleSize", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("particleColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F }, 4));
    initParams();
  }
  
  public void initParams()
  {
    this.mViewDistance = (this.near + (this.far - this.near) * 0.5F);
    addParam(new Param.Mat4Param("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
    addParam(new Param.IntParam("blendMode", 0));
    addParam(new Param.FloatParam("canvasWidth", 1.0F));
    addParam(new Param.FloatParam("canvasHeight", 1.0F));
    addParam(new Param.IntParam("isFrontCamera", 0));
    ARMatrixUtil.startOrientationSensor();
    this.mCopyFilter.ApplyGLSLFilter();
  }
  
  public boolean needCopyTex()
  {
    if (this.mSpriteList != null)
    {
      Iterator localIterator = this.mSpriteList.iterator();
      while (localIterator.hasNext())
      {
        Sprite localSprite = (Sprite)localIterator.next();
        if ((localSprite.blendMode >= 2) && (localSprite.blendMode <= 12)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean needCopyTex(int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= 12);
  }
  
  public void render(int paramInt)
  {
    Object localObject2 = this.frameDataBufferQueue[this.frameDataBufferQueueIndex];
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((FrameData)localObject2).ready) {}
    }
    else
    {
      if (this.mLastFrameData == null) {
        return;
      }
      localObject1 = this.mLastFrameData;
    }
    this.mLastFrameData = ((FrameData)localObject1);
    ((FrameData)localObject1).ready = false;
    this.frameDataBufferQueueIndex = ((this.frameDataBufferQueueIndex + 1) % 2);
    this.mParticleCalculationHandler.sendEmptyMessage(this.frameDataBufferQueueIndex);
    int i = 0;
    if ((i < ((FrameData)localObject1).frameParticleData.size()) && (i < this.mParticleDirList.size()))
    {
      localObject2 = (FrameParticleData)((FrameData)localObject1).frameParticleData.get(i);
      if (needCopyTex(((FrameParticleData)localObject2).blendMode))
      {
        this.mCopyFilter.RenderProcess(paramInt, this.width, this.height, -1, 0.0D, this.mCopyFrame);
        this.mInputFrame.bindFrame(-1, this.width, this.height, 0.0D);
        paramInt = this.mCopyFrame.getTextureId();
      }
      for (;;)
      {
        if (changeTexture((String)this.mParticleDirList.get(i) + File.separator + ((FrameParticleData)localObject2).tex)) {
          break label253;
        }
        i += 1;
        break;
        if (this.mInputFrame != null) {
          paramInt = this.mInputFrame.getTextureId();
        }
      }
      label253:
      setPositionIndex(((FrameParticleData)localObject2).positionIndex);
      setParticleCenter(((FrameParticleData)localObject2).particleCenter);
      setParticleSize(((FrameParticleData)localObject2).particleSize);
      setParticleColor(((FrameParticleData)localObject2).particleColor);
      setCoordNum(((FrameParticleData)localObject2).particleCount * 6);
      setTexCords(((FrameParticleData)localObject2).texCoords);
      addParam(new Param.IntParam("blendMode", ((FrameParticleData)localObject2).blendMode));
      addParam(new Param.Mat4Param("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
      addParam(new Param.FloatParam("canvasWidth", this.mCanvasWidth));
      addParam(new Param.FloatParam("canvasHeight", this.mCanvasHeight));
      if (ARMatrixUtil.isFrontCamera) {}
      for (int j = 1;; j = 0)
      {
        addParam(new Param.IntParam("isFrontCamera", j));
        OnDrawFrameGLSL();
        super.renderTexture(paramInt, this.width, this.height);
        break;
      }
    }
    playMusicIfNeeded((FrameData)localObject1);
  }
  
  public void setInputFrame(Frame paramFrame)
  {
    this.mInputFrame = paramFrame;
  }
  
  public boolean setParticleCenter(float[] paramArrayOfFloat)
  {
    addAttribParam(new AttributeParam("particleCenter", paramArrayOfFloat, 3));
    return true;
  }
  
  public boolean setParticleColor(float[] paramArrayOfFloat)
  {
    addAttribParam(new AttributeParam("particleColor", paramArrayOfFloat, 4));
    return true;
  }
  
  public boolean setParticleSize(float[] paramArrayOfFloat)
  {
    addAttribParam(new AttributeParam("particleSize", paramArrayOfFloat, 2));
    return true;
  }
  
  public boolean setPositionIndex(float[] paramArrayOfFloat)
  {
    addAttribParam(new AttributeParam("positionIndex", paramArrayOfFloat, 1));
    return true;
  }
  
  public void updateAndRender(int paramInt)
  {
    ARMatrixUtil.updateOrientation();
    render(paramInt);
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mCanvasWidth = paramInt1;
    this.mCanvasHeight = paramInt2;
    ARMatrixUtil.updateRenderSize(paramInt1, paramInt2);
  }
  
  class BitmapDecodeTask
    extends AsyncTask<Void, Void, Void>
  {
    BitmapDecodeTask() {}
    
    private void preCalTexCoords(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      int i = paramInt3 / paramInt5;
      int j = paramInt2 / paramInt4;
      float f1 = paramInt4 * 1.0F / paramInt2;
      float f2 = paramInt5 * 1.0F / paramInt3;
      ARParticleFilter.this.mTexCoords.add(paramInt1, new ArrayList());
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramInt3 = 0;
        while (paramInt3 < j)
        {
          PointF localPointF1 = new PointF(paramInt3 * f1, paramInt2 * f2);
          PointF localPointF2 = new PointF(localPointF1.x, localPointF1.y + f2);
          PointF localPointF3 = new PointF(localPointF1.x + f1, localPointF1.y);
          PointF localPointF4 = new PointF(localPointF3.x, localPointF1.y + f2);
          ARParticleFilter.TexCoord localTexCoord = new ARParticleFilter.TexCoord(ARParticleFilter.this);
          localTexCoord.texCoord[0] = localPointF3.x;
          localTexCoord.texCoord[1] = localPointF3.y;
          localTexCoord.texCoord[2] = localPointF4.x;
          localTexCoord.texCoord[3] = localPointF4.y;
          localTexCoord.texCoord[4] = localPointF2.x;
          localTexCoord.texCoord[5] = localPointF2.y;
          localTexCoord.texCoord[6] = localPointF3.x;
          localTexCoord.texCoord[7] = localPointF3.y;
          localTexCoord.texCoord[8] = localPointF2.x;
          localTexCoord.texCoord[9] = localPointF2.y;
          localTexCoord.texCoord[10] = localPointF1.x;
          localTexCoord.texCoord[11] = localPointF1.y;
          ((ArrayList)ARParticleFilter.this.mTexCoords.get(paramInt1)).add(localTexCoord);
          paramInt3 += 1;
        }
        paramInt2 += 1;
      }
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      int i;
      if ((ARParticleFilter.this.mSpriteList != null) && (ARParticleFilter.this.mParticleDirList != null))
      {
        i = 0;
        if ((i < ARParticleFilter.this.mSpriteList.size()) && (i < ARParticleFilter.this.mParticleDirList.size()))
        {
          if (!isCancelled()) {
            break label70;
          }
          QQLogUtils.i("ARParticleFilter", "decode background cancel!");
        }
      }
      return null;
      label70:
      Sprite localSprite = (Sprite)ARParticleFilter.this.mSpriteList.get(i);
      paramVarArgs = ARParticleFilter.this.dataPath + File.separator + (String)ARParticleFilter.this.mParticleDirList.get(i) + File.separator + localSprite.path;
      if (paramVarArgs.startsWith("assets://"))
      {
        paramVarArgs = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramVarArgs), 2147483647, 2147483647);
        label170:
        if (ARParticleFilter.this.isBitmapLegal(paramVarArgs)) {
          break label200;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramVarArgs = VideoBitmapUtil.decodeSampledBitmapFromFile(paramVarArgs, 2147483647, 2147483647);
        break label170;
        label200:
        preCalTexCoords(i, paramVarArgs.getWidth(), paramVarArgs.getHeight(), localSprite.width, localSprite.height);
        ARParticleFilter.this.mTextureBitmaps[i] = paramVarArgs;
      }
    }
  }
  
  class FrameData
  {
    public List<ARParticleFilter.FrameParticleData> frameParticleData = new ArrayList();
    public boolean needPlayMusic;
    public boolean ready;
    
    FrameData() {}
  }
  
  class FrameParticleData
  {
    public String audioPath;
    public int blendMode;
    public float[] particleCenter;
    public float[] particleColor;
    public int particleCount;
    public float[] particleSize;
    public float[] positionIndex;
    public String tex;
    public float[] texCoords;
    
    FrameParticleData() {}
  }
  
  class ParticleCalculationHandler
    extends Handler
  {
    public ParticleCalculationHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int j = paramMessage.what;
      paramMessage = new ARParticleFilter.FrameData(ARParticleFilter.this);
      List localList = ARParticleFilter.this.mParticleSystem.advance();
      if (localList == null) {
        return;
      }
      int i = 0;
      while ((i < localList.size()) && (i < ARParticleFilter.this.mSpriteList.size()) && (i < ARParticleFilter.this.mParticleDirList.size()))
      {
        FrameParticleData localFrameParticleData = (FrameParticleData)localList.get(i);
        Sprite localSprite = (Sprite)ARParticleFilter.this.mSpriteList.get(i);
        ARParticleFilter.FrameParticleData localFrameParticleData1 = new ARParticleFilter.FrameParticleData(ARParticleFilter.this);
        localFrameParticleData1.blendMode = localFrameParticleData.blendMode;
        localFrameParticleData1.particleCount = localFrameParticleData.particleCount;
        localFrameParticleData1.tex = localSprite.path;
        localFrameParticleData1.positionIndex = localFrameParticleData.positionIndex;
        localFrameParticleData1.particleCenter = localFrameParticleData.particleCenter;
        localFrameParticleData1.particleSize = localFrameParticleData.particleSize;
        localFrameParticleData1.texCoords = localFrameParticleData.texCoords;
        localFrameParticleData1.particleColor = localFrameParticleData.particleColor;
        localFrameParticleData1.audioPath = (ARParticleFilter.this.dataPath + File.separator + (String)ARParticleFilter.this.mParticleDirList.get(i) + File.separator + localSprite.audioPath);
        if ((!paramMessage.needPlayMusic) && (!TextUtils.isEmpty(localFrameParticleData.audioPath))) {
          paramMessage.needPlayMusic = localFrameParticleData.playAudio;
        }
        paramMessage.frameParticleData.add(localFrameParticleData1);
        i += 1;
      }
      ARParticleFilter.this.frameDataBufferQueue[j] = paramMessage;
      ARParticleFilter.this.frameDataBufferQueue[j].ready = true;
    }
  }
  
  class Size
  {
    public int height;
    public int width;
    
    Size() {}
    
    Size(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public boolean isValid()
    {
      return (this.width != 0) && (this.height != 0);
    }
  }
  
  class TexCoord
  {
    float[] texCoord = new float[12];
    
    TexCoord() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter
 * JD-Core Version:    0.7.0.1
 */