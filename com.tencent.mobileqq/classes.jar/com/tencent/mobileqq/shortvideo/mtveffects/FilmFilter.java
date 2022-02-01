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
    long l;
    if (getPlayMode() == 2) {
      l = -1L;
    } else {
      l = 1L;
    }
    RandomTime localRandomTime;
    if (this.mGaussianTime.mStartPos < 0L)
    {
      localRandomTime = this.mGaussianTime;
      localRandomTime.mStartPos = (this.mGaussianShowTime * l + paramLong);
      localRandomTime.mEndPos = (localRandomTime.mStartPos + l * 360L);
      this.mGaussianCurTimes = 0;
      return false;
    }
    if ((l != 1L) || (this.mGaussianTime.mStartPos <= paramLong))
    {
      if ((l == -1L) && (this.mGaussianTime.mStartPos < paramLong)) {
        return false;
      }
      if (((l == 1L) && (this.mGaussianTime.mEndPos > paramLong)) || ((l == -1L) && (this.mGaussianTime.mEndPos < paramLong))) {
        return true;
      }
      int i = this.mGaussianCurTimes;
      if (i == 0)
      {
        localRandomTime = this.mGaussianTime;
        localRandomTime.mStartPos = paramLong;
        localRandomTime.mEndPos = (localRandomTime.mStartPos + l * 200L);
        this.mGaussianCurTimes = 1;
        return false;
      }
      if (i == 1)
      {
        localRandomTime = this.mGaussianTime;
        localRandomTime.mStartPos = (paramLong + 800L * l);
        localRandomTime.mEndPos = (localRandomTime.mStartPos + l * 200L);
        this.mGaussianCurTimes = 2;
      }
    }
    return false;
  }
  
  private boolean isOverlapped(FilmFilter.NoiseItem paramNoiseItem1, FilmFilter.NoiseItem paramNoiseItem2)
  {
    if (paramNoiseItem1 != null)
    {
      if (paramNoiseItem2 == null) {
        return false;
      }
      if ((Math.abs(paramNoiseItem1.mDstRect.left - paramNoiseItem2.mDstRect.left) < paramNoiseItem1.mDstRect.width()) && (Math.abs(paramNoiseItem1.mDstRect.top - paramNoiseItem2.mDstRect.top) < paramNoiseItem1.mDstRect.height())) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private int loadImage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 215	com/tencent/mobileqq/shortvideo/mtveffects/FilmFilter:getMaterialPath	()Ljava/lang/String;
    //   4: astore 6
    //   6: aload 6
    //   8: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore 4
    //   13: iconst_m1
    //   14: istore_2
    //   15: iload 4
    //   17: ifeq +12 -> 29
    //   20: ldc 39
    //   22: ldc 223
    //   24: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: iconst_m1
    //   28: ireturn
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 7
    //   35: aconst_null
    //   36: astore 8
    //   38: new 231	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   45: astore 9
    //   47: aload 9
    //   49: aload 6
    //   51: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 9
    //   57: aload_1
    //   58: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 238	java/io/FileInputStream
    //   65: dup
    //   66: aload 9
    //   68: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 243	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   74: astore 6
    //   76: new 245	java/io/BufferedInputStream
    //   79: dup
    //   80: aload 6
    //   82: invokespecial 248	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore 5
    //   87: sipush 3553
    //   90: aload 5
    //   92: invokestatic 254	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   95: invokestatic 260	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   98: istore_3
    //   99: aload 6
    //   101: invokevirtual 265	java/io/InputStream:close	()V
    //   104: iload_3
    //   105: istore_2
    //   106: aload 5
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 265	java/io/InputStream:close	()V
    //   113: iload_2
    //   114: ireturn
    //   115: astore_1
    //   116: goto +15 -> 131
    //   119: astore 7
    //   121: aload 5
    //   123: astore_1
    //   124: goto +32 -> 156
    //   127: astore_1
    //   128: aconst_null
    //   129: astore 5
    //   131: aload 6
    //   133: astore 7
    //   135: aload 5
    //   137: astore 6
    //   139: goto +232 -> 371
    //   142: aconst_null
    //   143: astore 5
    //   145: aload 6
    //   147: astore 8
    //   149: goto +28 -> 177
    //   152: astore 7
    //   154: aconst_null
    //   155: astore_1
    //   156: aload 6
    //   158: astore 5
    //   160: aload 7
    //   162: astore 8
    //   164: goto +108 -> 272
    //   167: astore_1
    //   168: aconst_null
    //   169: astore 6
    //   171: goto +200 -> 371
    //   174: aconst_null
    //   175: astore 5
    //   177: aload 5
    //   179: astore 6
    //   181: aload 8
    //   183: astore 7
    //   185: new 231	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   192: astore 9
    //   194: aload 5
    //   196: astore 6
    //   198: aload 8
    //   200: astore 7
    //   202: aload 9
    //   204: ldc_w 267
    //   207: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: astore 6
    //   215: aload 8
    //   217: astore 7
    //   219: aload 9
    //   221: aload_1
    //   222: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 5
    //   228: astore 6
    //   230: aload 8
    //   232: astore 7
    //   234: ldc 39
    //   236: aload 9
    //   238: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 8
    //   246: ifnull +11 -> 257
    //   249: aload 8
    //   251: invokevirtual 265	java/io/InputStream:close	()V
    //   254: goto +3 -> 257
    //   257: aload 5
    //   259: ifnull +109 -> 368
    //   262: aload 5
    //   264: astore_1
    //   265: goto -156 -> 109
    //   268: astore 8
    //   270: aconst_null
    //   271: astore_1
    //   272: aload_1
    //   273: astore 6
    //   275: aload 5
    //   277: astore 7
    //   279: aload 8
    //   281: invokevirtual 270	java/lang/Exception:printStackTrace	()V
    //   284: aload_1
    //   285: astore 6
    //   287: aload 5
    //   289: astore 7
    //   291: new 231	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   298: astore 9
    //   300: aload_1
    //   301: astore 6
    //   303: aload 5
    //   305: astore 7
    //   307: aload 9
    //   309: ldc_w 272
    //   312: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: astore 6
    //   319: aload 5
    //   321: astore 7
    //   323: aload 9
    //   325: aload 8
    //   327: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: astore 6
    //   334: aload 5
    //   336: astore 7
    //   338: ldc 39
    //   340: aload 9
    //   342: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 229	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 5
    //   350: ifnull +11 -> 361
    //   353: aload 5
    //   355: invokevirtual 265	java/io/InputStream:close	()V
    //   358: goto +3 -> 361
    //   361: aload_1
    //   362: ifnull +6 -> 368
    //   365: goto -256 -> 109
    //   368: iconst_m1
    //   369: ireturn
    //   370: astore_1
    //   371: aload 7
    //   373: ifnull +11 -> 384
    //   376: aload 7
    //   378: invokevirtual 265	java/io/InputStream:close	()V
    //   381: goto +3 -> 384
    //   384: aload 6
    //   386: ifnull +8 -> 394
    //   389: aload 6
    //   391: invokevirtual 265	java/io/InputStream:close	()V
    //   394: goto +5 -> 399
    //   397: aload_1
    //   398: athrow
    //   399: goto -2 -> 397
    //   402: astore 5
    //   404: goto -230 -> 174
    //   407: astore 5
    //   409: goto -267 -> 142
    //   412: astore 7
    //   414: goto -269 -> 145
    //   417: astore_1
    //   418: aload 5
    //   420: astore_1
    //   421: iload_3
    //   422: istore_2
    //   423: goto -314 -> 109
    //   426: astore_1
    //   427: iload_2
    //   428: ireturn
    //   429: astore_1
    //   430: goto -173 -> 257
    //   433: astore 5
    //   435: goto -74 -> 361
    //   438: astore 5
    //   440: goto -56 -> 384
    //   443: astore 5
    //   445: goto -51 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	FilmFilter
    //   0	448	1	paramString	String
    //   14	414	2	i	int
    //   98	324	3	j	int
    //   11	5	4	bool	boolean
    //   30	324	5	localObject1	Object
    //   402	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   407	12	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   433	1	5	localIOException1	java.io.IOException
    //   438	1	5	localIOException2	java.io.IOException
    //   443	1	5	localIOException3	java.io.IOException
    //   4	386	6	localObject2	Object
    //   33	1	7	localObject3	Object
    //   119	1	7	localException1	java.lang.Exception
    //   133	1	7	localObject4	Object
    //   152	9	7	localException2	java.lang.Exception
    //   183	194	7	localObject5	Object
    //   412	1	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   36	214	8	localObject6	Object
    //   268	58	8	localException3	java.lang.Exception
    //   45	296	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   87	99	115	finally
    //   87	99	119	java/lang/Exception
    //   76	87	127	finally
    //   76	87	152	java/lang/Exception
    //   38	76	167	finally
    //   38	76	268	java/lang/Exception
    //   185	194	370	finally
    //   202	211	370	finally
    //   219	226	370	finally
    //   234	244	370	finally
    //   279	284	370	finally
    //   291	300	370	finally
    //   307	316	370	finally
    //   323	331	370	finally
    //   338	348	370	finally
    //   38	76	402	java/lang/OutOfMemoryError
    //   76	87	407	java/lang/OutOfMemoryError
    //   87	99	412	java/lang/OutOfMemoryError
    //   99	104	417	java/io/IOException
    //   109	113	426	java/io/IOException
    //   249	254	429	java/io/IOException
    //   353	358	433	java/io/IOException
    //   376	381	438	java/io/IOException
    //   389	394	443	java/io/IOException
  }
  
  private void randomNoiseItems()
  {
    if (this.mRenderFBO == null) {
      return;
    }
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
  
  private void selectGaussianFilter(long paramLong)
  {
    int j = getPlayMode();
    int i = 2;
    long l2;
    long l1;
    if (j != 2)
    {
      if ((paramLong <= this.mGaussianTime.mEndPos) && (paramLong >= this.mGaussianTime.mStartPos))
      {
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
        if (l1 >= 9L) {}
        do
        {
          l1 = 9L;
          break;
          while (i < 5)
          {
            j = i + 1;
            if (l1 < j * 2 - 1)
            {
              l1 = i * 2 - 1;
              break;
            }
            i = j;
          }
        } while (i == 5);
        l2 = this.mGaussianTime.mStartPos;
        i = (int)((this.mGaussianTime.mEndPos - this.mGaussianTime.mStartPos) / l1);
        i = (int)(paramLong - l2) / (i + 1);
        paramLong = i;
        l1 -= 1L;
        if (paramLong <= l1 / 2L)
        {
          this.mGaussianFilterIndex = i;
          return;
        }
        this.mGaussianFilterIndex = ((int)l1 - i);
        return;
      }
      this.mGaussianFilterIndex = -1;
      return;
    }
    if ((paramLong >= this.mGaussianTime.mEndPos) && (paramLong <= this.mGaussianTime.mStartPos))
    {
      l2 = (this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos) / 40L;
      l1 = l2;
      if (this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos - 40L * l2 > 0L) {
        l1 = l2 + 1L;
      }
      if (l1 <= 2L)
      {
        this.mGaussianFilterIndex = 0;
        return;
      }
      l2 = 9L;
      if (l1 >= 9L)
      {
        l1 = l2;
      }
      else
      {
        while (i < 5)
        {
          j = i + 1;
          if (l1 < j * 2 - 1)
          {
            l1 = i * 2 - 1;
            break;
          }
          i = j;
        }
        if (i == 5) {
          l1 = l2;
        }
      }
      l2 = this.mGaussianTime.mStartPos;
      i = (int)((this.mGaussianTime.mStartPos - this.mGaussianTime.mEndPos) / l1);
      i = (int)(l2 - paramLong) / (i + 1);
      paramLong = i;
      l1 -= 1L;
      if (paramLong <= l1 / 2L)
      {
        this.mGaussianFilterIndex = i;
        return;
      }
      this.mGaussianFilterIndex = ((int)l1 - i);
      return;
    }
    this.mGaussianFilterIndex = -1;
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
    FilmColorFilter localFilmColorFilter = this.mFilmFilter;
    int i;
    if (localFilmColorFilter != null)
    {
      i = this.mPaletteID;
      if (i >= 0)
      {
        bool = localFilmColorFilter.process(paramInt, i, paramArrayOfFloat1, paramArrayOfFloat2);
        break label89;
      }
    }
    boolean bool = false;
    label89:
    if ((this.mShowNoise) && (this.mNoiseFilter != null) && (this.mNoiseItems.size() > 0) && (this.mMaterialID >= 0))
    {
      this.mNoiseFilter.updateData(this.mNoiseItems);
      this.mNoiseFilter.process(this.mMaterialID, paramArrayOfFloat1, paramArrayOfFloat2);
    }
    paramRenderBuffer.unbind();
    if (bool) {
      paramInt = paramRenderBuffer.getTexId();
    }
    if (this.mShowGaussian)
    {
      int j = this.mGaussianFilterIndex;
      if ((j >= 0) && (j < this.mGaussianFilters.length))
      {
        i = paramInt;
        if (this.mScaleFilter != null)
        {
          i = paramInt;
          if (this.mRenderFBO != null)
          {
            i = paramInt;
            if (this.mGaussianCurTimes != 2)
            {
              paramFloat = calcScaleRate(j);
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
    }
    return bool;
  }
  
  public void onReset(long paramLong)
  {
    resetInner(paramLong);
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      Object localObject = this.mNoiseFilter;
      if (localObject != null)
      {
        ((FilmNoiseFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mNoiseFilter = new FilmNoiseFilter();
        this.mNoiseFilter.init();
        if (this.mNoiseFilter.isInitialized())
        {
          this.mNoiseFilter.onOutputSizeChanged(paramInt1, paramInt2);
        }
        else
        {
          this.mNoiseFilter.destroy();
          this.mNoiseFilter = null;
        }
      }
      localObject = this.mFilmFilter;
      if (localObject != null)
      {
        ((FilmColorFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mFilmFilter = new FilmColorFilter();
        this.mFilmFilter.init();
        if (this.mFilmFilter.isInitialized())
        {
          this.mFilmFilter.onOutputSizeChanged(paramInt1, paramInt2);
        }
        else
        {
          this.mFilmFilter.destroy();
          this.mFilmFilter = null;
        }
      }
      localObject = this.mScaleFilter;
      if (localObject != null)
      {
        ((ScaleFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mScaleFilter = new ScaleFilter();
        this.mScaleFilter.init();
        if (this.mScaleFilter.isInitialized())
        {
          this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
        }
        else
        {
          this.mScaleFilter.destroy();
          this.mScaleFilter = null;
        }
      }
      int i = 0;
      for (;;)
      {
        localObject = this.mGaussianFilters;
        if (i >= localObject.length) {
          break;
        }
        if (localObject[i] != null)
        {
          localObject[i].onOutputSizeChanged(paramInt1, paramInt2);
        }
        else
        {
          localObject[i] = new QQAVImageDenoiseGaussianBlurFilter(20 / localObject.length * i);
          this.mGaussianFilters[i].init();
          this.mGaussianFilters[i].onOutputSizeChanged(paramInt1, paramInt2);
        }
        i += 1;
      }
      localObject = this.mRenderFBO;
      if ((localObject == null) || (((RenderBuffer)localObject).getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
      {
        localObject = this.mRenderFBO;
        if (localObject != null)
        {
          ((RenderBuffer)localObject).destroy();
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
      i = 0;
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
    Object localObject = this.mFilmFilter;
    if (localObject != null)
    {
      ((FilmColorFilter)localObject).destroy();
      this.mFilmFilter = null;
    }
    localObject = this.mNoiseFilter;
    if (localObject != null)
    {
      ((FilmNoiseFilter)localObject).destroy();
      this.mNoiseFilter = null;
    }
    localObject = this.mScaleFilter;
    if (localObject != null)
    {
      ((ScaleFilter)localObject).destroy();
      this.mScaleFilter = null;
    }
    int i = this.mMaterialID;
    if (i >= 0)
    {
      GlUtil.deleteTexture(i);
      this.mMaterialID = -1;
    }
    i = this.mPaletteID;
    if (i >= 0)
    {
      GlUtil.deleteTexture(i);
      this.mPaletteID = -1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.mGaussianFilters;
      if (i >= localObject.length) {
        break;
      }
      localObject[i].destroy();
      this.mGaussianFilters[i] = null;
      i += 1;
    }
    this.mGaussianFilterIndex = -1;
    this.mNoiseItems.clear();
    localObject = this.mRenderFBO;
    if (localObject != null)
    {
      if (((RenderBuffer)localObject).getTexId() >= 0) {
        GlUtil.deleteTexture(this.mRenderFBO.getTexId());
      }
      this.mRenderFBO.destroy();
    }
    localObject = this.mFrameBuffers;
    if (localObject.length > 0) {
      GLES20.glDeleteFramebuffers(localObject.length, (int[])localObject, 0);
    }
    localObject = this.mFrameBufferTextures;
    if (localObject.length > 0) {
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.FilmFilter
 * JD-Core Version:    0.7.0.1
 */