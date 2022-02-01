package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseGaussianBlurFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class FilmFilter
  extends MTVBaseFilter
{
  private static final int FIRSET_GAUSSIAN_SHOW_TIME = 360;
  private static final int GAUSSIAN_FILTER_COUNT = 5;
  private static final String MATERIAL_FILE_NAME = "TVErrorNoises.png";
  private static final int MAX_GAUSSIAN_FILTER_RADIUS = 20;
  private static final int MAX_NOISE_COUNT = 18;
  private static final int MAX_NOISE_SHOW_COUNT = 3;
  private static final int MAX_NOISE_SHOW_INTERVAL = 50;
  private static final int MAX_NOISE_SHOW_TIME = 800;
  private static final int MIN_NOISE_SHOW_COUNT = 1;
  private static final int MIN_NOISE_SHOW_TIME = 500;
  private static final int NOISE_ITEM_WIDTH_PX = 79;
  private static final String PALETTE_FILE_NAME = "effectcombofilm.png";
  private static final int PER_GAUSSIAN_SHOW_TIME = 40;
  private static final int SECOND_GAUSSIAN_SHOW_TIME = 200;
  private static final String TAG = "FilmFilter";
  private static final int THIRD_GAUSSIAN_SHOW_DELTA = 800;
  private FilmColorFilter mFilmFilter;
  private int[] mFrameBufferTextures = new int[1];
  private int[] mFrameBuffers = new int[1];
  private int mGaussianCurTimes = 0;
  private int mGaussianFilterIndex = -1;
  private QQAVImageDenoiseGaussianBlurFilter[] mGaussianFilters = new QQAVImageDenoiseGaussianBlurFilter[5];
  private long mGaussianShowTime = 1300L;
  private RandomTime mGaussianTime = new RandomTime(false);
  private int mMaterialID = -1;
  private FilmNoiseFilter mNoiseFilter;
  private ArrayList<FilmFilter.NoiseItem> mNoiseItems = new ArrayList();
  private RandomTime mNoiseShowTime = new RandomTime();
  private int mPaletteID = -1;
  private RandomGenerator mRandom = new RandomGenerator(System.currentTimeMillis());
  private RenderBuffer mRenderFBO;
  private ScaleFilter mScaleFilter;
  private boolean mShowGaussian = false;
  private boolean mShowNoise = false;
  
  public FilmFilter(String paramString)
  {
    super(1018, paramString);
  }
  
  private float calcScaleRate(int paramInt)
  {
    return paramInt * 1.0F / 60.0F + 1.0F;
  }
  
  private void checkData(long paramLong)
  {
    this.mShowGaussian = checkGaussianTime(paramLong);
    if (this.mShowGaussian) {
      selectGaussianFilter(paramLong);
    }
    if ((checkRandomTime(this.mNoiseShowTime, paramLong, 500L, 800L, 50L)) && (!this.mShowNoise))
    {
      randomNoiseItems();
      if (this.mNoiseItems.size() == 0)
      {
        this.mShowNoise = false;
        return;
      }
      this.mShowNoise = true;
      return;
    }
    this.mShowNoise = false;
  }
  
  private boolean checkGaussianTime(long paramLong)
  {
    if (this.mGaussianTime == null) {
      return false;
    }
    if (getPlayMode() == 0) {
      return false;
    }
    if (this.mGaussianShowTime < 0L) {
      return false;
    }
    if (getPlayMode() == 2) {}
    for (long l = -1L;; l = 1L)
    {
      if (this.mGaussianTime.mStartPos < 0L)
      {
        this.mGaussianTime.mStartPos = (this.mGaussianShowTime * l + paramLong);
        this.mGaussianTime.mEndPos = (l * 360L + this.mGaussianTime.mStartPos);
        this.mGaussianCurTimes = 0;
      }
      for (;;)
      {
        return false;
        if (((l != 1L) || (this.mGaussianTime.mStartPos <= paramLong)) && ((l != -1L) || (this.mGaussianTime.mStartPos >= paramLong)))
        {
          if (((l == 1L) && (this.mGaussianTime.mEndPos > paramLong)) || ((l == -1L) && (this.mGaussianTime.mEndPos < paramLong))) {
            return true;
          }
          if (this.mGaussianCurTimes == 0)
          {
            this.mGaussianTime.mStartPos = paramLong;
            this.mGaussianTime.mEndPos = (l * 200L + this.mGaussianTime.mStartPos);
            this.mGaussianCurTimes = 1;
          }
          else if (this.mGaussianCurTimes == 1)
          {
            this.mGaussianTime.mStartPos = (800L * l + paramLong);
            this.mGaussianTime.mEndPos = (l * 200L + this.mGaussianTime.mStartPos);
            this.mGaussianCurTimes = 2;
          }
        }
      }
    }
  }
  
  private boolean isOverlapped(FilmFilter.NoiseItem paramNoiseItem1, FilmFilter.NoiseItem paramNoiseItem2)
  {
    if ((paramNoiseItem1 == null) || (paramNoiseItem2 == null)) {}
    while ((Math.abs(paramNoiseItem1.mDstRect.left - paramNoiseItem2.mDstRect.left) >= paramNoiseItem1.mDstRect.width()) || (Math.abs(paramNoiseItem1.mDstRect.top - paramNoiseItem2.mDstRect.top) >= paramNoiseItem1.mDstRect.height())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private int loadImage(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_m1
    //   10: istore_2
    //   11: aload_0
    //   12: invokevirtual 215	com/tencent/mobileqq/shortvideo/mtveffects/FilmFilter:getMaterialPath	()Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +12 -> 34
    //   25: ldc 39
    //   27: ldc 223
    //   29: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: iload_2
    //   33: ireturn
    //   34: new 231	java/io/FileInputStream
    //   37: dup
    //   38: new 233	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   45: aload 4
    //   47: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 243	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: astore 4
    //   62: new 245	java/io/BufferedInputStream
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 248	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 5
    //   73: sipush 3553
    //   76: aload 5
    //   78: invokestatic 254	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   81: invokestatic 260	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   84: istore_3
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 265	java/io/InputStream:close	()V
    //   95: iload_3
    //   96: istore_2
    //   97: aload 5
    //   99: ifnull -67 -> 32
    //   102: aload 5
    //   104: invokevirtual 265	java/io/InputStream:close	()V
    //   107: iload_3
    //   108: ireturn
    //   109: astore_1
    //   110: iload_3
    //   111: ireturn
    //   112: astore 5
    //   114: aconst_null
    //   115: astore 4
    //   117: aload 6
    //   119: astore_1
    //   120: aload 5
    //   122: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   125: ldc 39
    //   127: new 233	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 270
    //   137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 5
    //   142: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 265	java/io/InputStream:close	()V
    //   161: aload_1
    //   162: ifnull -130 -> 32
    //   165: aload_1
    //   166: invokevirtual 265	java/io/InputStream:close	()V
    //   169: iconst_m1
    //   170: ireturn
    //   171: astore_1
    //   172: iconst_m1
    //   173: ireturn
    //   174: astore 4
    //   176: aconst_null
    //   177: astore 5
    //   179: aload 7
    //   181: astore 4
    //   183: ldc 39
    //   185: new 233	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 275
    //   195: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 4
    //   210: ifnull +8 -> 218
    //   213: aload 4
    //   215: invokevirtual 265	java/io/InputStream:close	()V
    //   218: aload 5
    //   220: ifnull -188 -> 32
    //   223: aload 5
    //   225: invokevirtual 265	java/io/InputStream:close	()V
    //   228: iconst_m1
    //   229: ireturn
    //   230: astore_1
    //   231: iconst_m1
    //   232: ireturn
    //   233: astore_1
    //   234: aconst_null
    //   235: astore 5
    //   237: aload 8
    //   239: astore 4
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 265	java/io/InputStream:close	()V
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 265	java/io/InputStream:close	()V
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: goto -169 -> 95
    //   267: astore 4
    //   269: goto -108 -> 161
    //   272: astore_1
    //   273: goto -55 -> 218
    //   276: astore 4
    //   278: goto -27 -> 251
    //   281: astore 4
    //   283: goto -22 -> 261
    //   286: astore_1
    //   287: aconst_null
    //   288: astore 5
    //   290: goto -49 -> 241
    //   293: astore_1
    //   294: goto -53 -> 241
    //   297: astore 6
    //   299: aload_1
    //   300: astore 5
    //   302: aload 6
    //   304: astore_1
    //   305: goto -64 -> 241
    //   308: astore_1
    //   309: goto -68 -> 241
    //   312: astore 5
    //   314: aconst_null
    //   315: astore 5
    //   317: goto -134 -> 183
    //   320: astore 6
    //   322: goto -139 -> 183
    //   325: astore 5
    //   327: aload 6
    //   329: astore_1
    //   330: goto -210 -> 120
    //   333: astore 6
    //   335: aload 5
    //   337: astore_1
    //   338: aload 6
    //   340: astore 5
    //   342: goto -222 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	FilmFilter
    //   0	345	1	paramString	String
    //   10	87	2	i	int
    //   84	27	3	j	int
    //   15	142	4	localObject1	java.lang.Object
    //   174	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   181	66	4	localObject2	java.lang.Object
    //   267	1	4	localIOException1	java.io.IOException
    //   276	1	4	localIOException2	java.io.IOException
    //   281	1	4	localIOException3	java.io.IOException
    //   71	32	5	localBufferedInputStream	java.io.BufferedInputStream
    //   112	29	5	localException1	java.lang.Exception
    //   177	124	5	str	String
    //   312	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   315	1	5	localObject3	java.lang.Object
    //   325	11	5	localException2	java.lang.Exception
    //   340	1	5	localException3	java.lang.Exception
    //   7	111	6	localObject4	java.lang.Object
    //   297	6	6	localObject5	java.lang.Object
    //   320	8	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   333	6	6	localException4	java.lang.Exception
    //   1	179	7	localObject6	java.lang.Object
    //   4	234	8	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   102	107	109	java/io/IOException
    //   34	62	112	java/lang/Exception
    //   165	169	171	java/io/IOException
    //   34	62	174	java/lang/OutOfMemoryError
    //   223	228	230	java/io/IOException
    //   34	62	233	finally
    //   90	95	263	java/io/IOException
    //   156	161	267	java/io/IOException
    //   213	218	272	java/io/IOException
    //   246	251	276	java/io/IOException
    //   256	261	281	java/io/IOException
    //   62	73	286	finally
    //   73	85	293	finally
    //   120	151	297	finally
    //   183	208	308	finally
    //   62	73	312	java/lang/OutOfMemoryError
    //   73	85	320	java/lang/OutOfMemoryError
    //   62	73	325	java/lang/Exception
    //   73	85	333	java/lang/Exception
  }
  
  private void randomNoiseItems()
  {
    if (this.mRenderFBO == null) {}
    for (;;)
    {
      return;
      this.mNoiseItems.clear();
      long l = this.mRandom.nextLong(1L, 3L);
      int i = 0;
      while (i < l)
      {
        FilmFilter.NoiseItem localNoiseItem = new FilmFilter.NoiseItem();
        localNoiseItem.mSrcLength = 0.05555556F;
        localNoiseItem.mSrcX = ((float)this.mRandom.nextLong(0L, 18L) * localNoiseItem.mSrcLength);
        localNoiseItem.mDstRect.left = ((float)this.mRandom.nextLong(0L, this.mRenderFBO.getWidth() - 79) * 1.0F / this.mRenderFBO.getWidth());
        localNoiseItem.mDstRect.top = (1.0F - (float)this.mRandom.nextLong(0L, this.mRenderFBO.getHeight() - 79) * 1.0F / this.mRenderFBO.getHeight());
        localNoiseItem.mDstRect.right = (localNoiseItem.mDstRect.left + 0.05555556F);
        localNoiseItem.mDstRect.bottom = (localNoiseItem.mDstRect.top - 0.05555556F);
        tryAddNoiseItem(localNoiseItem);
        i += 1;
      }
    }
  }
  
  private void selectGaussianFilter(long paramLong)
  {
    int i;
    if (getPlayMode() != 2)
    {
      if ((paramLong > this.mGaussianTime.mEndPos) || (paramLong < this.mGaussianTime.mStartPos))
      {
        this.mGaussianFilterIndex = -1;
        return;
      }
      l2 = (this.mGaussianTime.mEndPos - this.mGaussianTime.mStartPos) / 40L;
      l1 = l2;
      if (this.mGaussianTime.mEndPos - this.mGaussianTime.mStartPos - 40L * l2 > 0L) {
        l1 = l2 + 1L;
      }
      if (l1 <= 2L)
      {
        this.mGaussianFilterIndex = 0;
        return;
      }
      if (l1 >= 9L)
      {
        l1 = 9L;
        l2 = this.mGaussianTime.mStartPos;
        i = (int)((this.mGaussianTime.mEndPos - this.mGaussianTime.mStartPos) / l1);
        i = (int)(paramLong - l2) / (i + 1);
        if (i <= (l1 - 1L) / 2L) {
          this.mGaussianFilterIndex = i;
        }
      }
      else
      {
        i = 2;
        for (;;)
        {
          l2 = l1;
          if (i < 5)
          {
            if (l1 < (i + 1) * 2 - 1) {
              l2 = i * 2 - 1;
            }
          }
          else
          {
            l1 = l2;
            if (i != 5) {
              break;
            }
            l1 = 9L;
            break;
          }
          i += 1;
        }
      }
      this.mGaussianFilterIndex = ((int)(l1 - 1L) - i);
      return;
    }
    if ((paramLong < this.mGaussianTime.mEndPos) || (paramLong > this.mGaussianTime.mStartPos))
    {
      this.mGaussianFilterIndex = -1;
      return;
    }
    long l2 = (this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos) / 40L;
    long l1 = l2;
    if (this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos - 40L * l2 > 0L) {
      l1 = l2 + 1L;
    }
    if (l1 <= 2L)
    {
      this.mGaussianFilterIndex = 0;
      return;
    }
    if (l1 >= 9L)
    {
      l1 = 9L;
      l2 = this.mGaussianTime.mStartPos;
      i = (int)((this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos) / l1);
      i = (int)(l2 - paramLong) / (i + 1);
      if (i <= (l1 - 1L) / 2L) {
        this.mGaussianFilterIndex = i;
      }
    }
    else
    {
      i = 2;
      for (;;)
      {
        l2 = l1;
        if (i < 5)
        {
          if (l1 < (i + 1) * 2 - 1) {
            l2 = i * 2 - 1;
          }
        }
        else
        {
          l1 = l2;
          if (i != 5) {
            break;
          }
          l1 = 9L;
          break;
        }
        i += 1;
      }
    }
    this.mGaussianFilterIndex = ((int)(l1 - 1L) - i);
  }
  
  private void tryAddNoiseItem(FilmFilter.NoiseItem paramNoiseItem)
  {
    if (paramNoiseItem == null) {
      return;
    }
    if (this.mNoiseItems.size() == 0)
    {
      this.mNoiseItems.add(paramNoiseItem);
      return;
    }
    Iterator localIterator = this.mNoiseItems.iterator();
    while (localIterator.hasNext()) {
      if (isOverlapped((FilmFilter.NoiseItem)localIterator.next(), paramNoiseItem)) {
        return;
      }
    }
    this.mNoiseItems.add(paramNoiseItem);
  }
  
  public boolean onDraw(RenderBuffer paramRenderBuffer, int paramInt, long paramLong, float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super.onDraw(paramRenderBuffer, paramInt, paramLong, paramFloat, paramArrayOfFloat1, paramArrayOfFloat2);
    if ((this.mMaterialID < 0) && (this.mPaletteID < 0))
    {
      SLog.d("FilmFilter", "materialID and paletteID is error");
      return false;
    }
    checkData(paramLong);
    paramRenderBuffer.bind();
    if ((this.mFilmFilter != null) && (this.mPaletteID >= 0)) {}
    for (boolean bool = this.mFilmFilter.process(paramInt, this.mPaletteID, paramArrayOfFloat1, paramArrayOfFloat2);; bool = false)
    {
      if ((this.mShowNoise) && (this.mNoiseFilter != null) && (this.mNoiseItems.size() > 0) && (this.mMaterialID >= 0))
      {
        this.mNoiseFilter.updateData(this.mNoiseItems);
        this.mNoiseFilter.process(this.mMaterialID, paramArrayOfFloat1, paramArrayOfFloat2);
      }
      paramRenderBuffer.unbind();
      if (bool) {
        paramInt = paramRenderBuffer.getTexId();
      }
      for (;;)
      {
        if ((this.mShowGaussian) && (this.mGaussianFilterIndex >= 0) && (this.mGaussianFilterIndex < this.mGaussianFilters.length))
        {
          int i = paramInt;
          if (this.mScaleFilter != null)
          {
            i = paramInt;
            if (this.mRenderFBO != null)
            {
              i = paramInt;
              if (this.mGaussianCurTimes != 2)
              {
                paramFloat = calcScaleRate(this.mGaussianFilterIndex);
                this.mRenderFBO.bind();
                bool = this.mScaleFilter.process(paramInt, 0.5F, 0.5F, paramFloat, null, null);
                this.mRenderFBO.unbind();
                i = paramInt;
                if (bool) {
                  i = this.mRenderFBO.getTexId();
                }
              }
            }
          }
          paramArrayOfFloat1 = this.mGaussianFilters[this.mGaussianFilterIndex];
          if (paramArrayOfFloat1 != null) {
            paramArrayOfFloat1.onDraw2(i, this.mFrameBuffers[0]);
          }
          updateRendBuffer(paramRenderBuffer, this.mFrameBufferTextures[0]);
          return true;
        }
        return bool;
      }
    }
  }
  
  public void onReset(long paramLong)
  {
    resetInner(paramLong);
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    for (;;)
    {
      return;
      if (this.mNoiseFilter != null)
      {
        this.mNoiseFilter.onOutputSizeChanged(paramInt1, paramInt2);
        if (this.mFilmFilter == null) {
          break label156;
        }
        this.mFilmFilter.onOutputSizeChanged(paramInt1, paramInt2);
        label47:
        if (this.mScaleFilter == null) {
          break label211;
        }
        this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
        label63:
        i = 0;
        label65:
        if (i >= this.mGaussianFilters.length) {
          break label313;
        }
        if (this.mGaussianFilters[i] == null) {
          break label266;
        }
        this.mGaussianFilters[i].onOutputSizeChanged(paramInt1, paramInt2);
      }
      for (;;)
      {
        i += 1;
        break label65;
        this.mNoiseFilter = new FilmNoiseFilter();
        this.mNoiseFilter.init();
        if (this.mNoiseFilter.isInitialized())
        {
          this.mNoiseFilter.onOutputSizeChanged(paramInt1, paramInt2);
          break;
        }
        this.mNoiseFilter.destroy();
        this.mNoiseFilter = null;
        break;
        label156:
        this.mFilmFilter = new FilmColorFilter();
        this.mFilmFilter.init();
        if (this.mFilmFilter.isInitialized())
        {
          this.mFilmFilter.onOutputSizeChanged(paramInt1, paramInt2);
          break label47;
        }
        this.mFilmFilter.destroy();
        this.mFilmFilter = null;
        break label47;
        label211:
        this.mScaleFilter = new ScaleFilter();
        this.mScaleFilter.init();
        if (this.mScaleFilter.isInitialized())
        {
          this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
          break label63;
        }
        this.mScaleFilter.destroy();
        this.mScaleFilter = null;
        break label63;
        label266:
        this.mGaussianFilters[i] = new QQAVImageDenoiseGaussianBlurFilter(20 / this.mGaussianFilters.length * i);
        this.mGaussianFilters[i].init();
        this.mGaussianFilters[i].onOutputSizeChanged(paramInt1, paramInt2);
      }
      label313:
      if ((this.mRenderFBO == null) || (this.mRenderFBO.getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
      {
        if (this.mRenderFBO != null)
        {
          this.mRenderFBO.destroy();
          this.mRenderFBO = null;
        }
        this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      if (this.mMaterialID < 0) {
        this.mMaterialID = loadImage("TVErrorNoises.png");
      }
      if (this.mPaletteID < 0) {
        this.mPaletteID = loadImage("effectcombofilm.png");
      }
      int j = this.mFrameBufferTextures.length;
      int i = 0;
      while (i < j)
      {
        GLES20.glGenFramebuffers(1, this.mFrameBuffers, i);
        GLES20.glGenTextures(1, this.mFrameBufferTextures, i);
        GLES20.glBindTexture(3553, this.mFrameBufferTextures[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mFilmFilter != null)
    {
      this.mFilmFilter.destroy();
      this.mFilmFilter = null;
    }
    if (this.mNoiseFilter != null)
    {
      this.mNoiseFilter.destroy();
      this.mNoiseFilter = null;
    }
    if (this.mScaleFilter != null)
    {
      this.mScaleFilter.destroy();
      this.mScaleFilter = null;
    }
    if (this.mMaterialID >= 0)
    {
      GlUtil.deleteTexture(this.mMaterialID);
      this.mMaterialID = -1;
    }
    if (this.mPaletteID >= 0)
    {
      GlUtil.deleteTexture(this.mPaletteID);
      this.mPaletteID = -1;
    }
    int i = 0;
    while (i < this.mGaussianFilters.length)
    {
      this.mGaussianFilters[i].destroy();
      this.mGaussianFilters[i] = null;
      i += 1;
    }
    this.mGaussianFilterIndex = -1;
    this.mNoiseItems.clear();
    if (this.mRenderFBO != null)
    {
      if (this.mRenderFBO.getTexId() >= 0) {
        GlUtil.deleteTexture(this.mRenderFBO.getTexId());
      }
      this.mRenderFBO.destroy();
    }
    if (this.mFrameBuffers.length > 0) {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
    }
    if (this.mFrameBufferTextures.length > 0) {
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
  }
  
  public void resetInner(long paramLong)
  {
    this.mShowGaussian = false;
    this.mShowNoise = false;
    this.mGaussianTime.reset();
    this.mNoiseShowTime.reset();
    this.mNoiseItems.clear();
  }
  
  public void setSeed(long paramLong)
  {
    this.mRandom.setSeed(paramLong);
  }
  
  public void setZoomingTime(long paramLong)
  {
    this.mGaussianCurTimes = 0;
    this.mGaussianShowTime = paramLong;
    this.mGaussianTime.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.FilmFilter
 * JD-Core Version:    0.7.0.1
 */