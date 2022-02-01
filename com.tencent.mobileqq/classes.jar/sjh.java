import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class sjh
  extends AsyncTask<String, Void, Integer>
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoConverter jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter;
  private String jdField_a_of_type_JavaLangString;
  private sjj jdField_a_of_type_Sjj;
  private sjl jdField_a_of_type_Sjl;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private sjl jdField_b_of_type_Sjl;
  private String c;
  
  public sjh(Context paramContext, sjj paramsjj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sjj = paramsjj;
  }
  
  private int a(Context paramContext, String paramString1, sjl paramsjl, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      int i = ShortVideoCodec.checkSupportMediaCodecFeature(paramContext);
      if (((i & 0x1) > 0) && ((i & 0x2) > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
        }
        if (!bool) {
          break label198;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
        }
        paramContext = new File(paramString1);
        paramString1 = new sji(this, paramString2, (int)(paramsjl.jdField_b_of_type_Long * 1024L), (int)paramsjl.jdField_a_of_type_Long, 0L, paramsjl.c);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter = new VideoConverter();
        if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter.start(paramContext, paramString1, true)) || (paramString1.a != null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr", paramString1.a);
      }
      return -4;
    }
    return -2;
    label198:
    return -4;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_Sjj.a(0.0F);
    if (TextUtils.isEmpty(paramVarArgs))
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, sdk version too low: " + Build.VERSION.SDK_INT);
      return Integer.valueOf(-2);
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    this.jdField_a_of_type_Sjl = sjl.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Sjl == null)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, retrive mSourceMediaInfo failed! ");
      return Integer.valueOf(-3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: retrive mSourceMediaInfo = " + this.jdField_a_of_type_Sjl);
    }
    if (!sjk.a(this.jdField_a_of_type_Sjl))
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, no need compress! ");
      return Integer.valueOf(-5);
    }
    long l1 = System.currentTimeMillis();
    File localFile = new File(sjk.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf(".");
    if (i == -1)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    this.jdField_b_of_type_JavaLangString = sjk.a(paramVarArgs, paramVarArgs.substring(i + 1));
    i = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sjl, this.jdField_b_of_type_JavaLangString);
    if (i == 0) {
      this.jdField_b_of_type_Sjl = sjl.a(this.jdField_b_of_type_JavaLangString);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask run finish! compress ret = " + i + ", cost:" + (l2 - l1) + "ms, mTargetMdeiaInfo=" + this.jdField_b_of_type_Sjl);
    }
    return Integer.valueOf(i);
  }
  
  public void a()
  {
    cancel(false);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter.stop();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter.cancel();
    }
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 2;
    super.onPostExecute(paramInteger);
    if (isCancelled()) {}
    label261:
    for (;;)
    {
      return;
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (paramInteger.intValue() != -2) {}
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Sjj == null) {
          break label261;
        }
        this.jdField_a_of_type_Sjj.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sjl);
        return;
        if (paramInteger.intValue() == -3)
        {
          i = 3;
        }
        else
        {
          if (paramInteger.intValue() == -5)
          {
            i = 1;
            continue;
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
            for (paramInteger = this.jdField_a_of_type_JavaLangString;; paramInteger = this.jdField_b_of_type_JavaLangString)
            {
              this.c = paramInteger;
              long l = new File(this.c).length();
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, finalSize:" + l);
              }
              if (l <= sjk.b()) {
                break label232;
              }
              if (this.jdField_a_of_type_Sjj == null) {
                break;
              }
              this.jdField_a_of_type_Sjj.a(5, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Sjl);
              return;
            }
            label232:
            if (this.jdField_a_of_type_Sjj == null) {
              break;
            }
            this.jdField_a_of_type_Sjj.a(0, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Sjl);
            return;
          }
          i = 4;
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */