import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lfw
{
  private static lfw jdField_a_of_type_Lfw;
  private lld jdField_a_of_type_Lld;
  
  private lfw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
    }
  }
  
  public static lfw a()
  {
    if (jdField_a_of_type_Lfw == null) {}
    try
    {
      if (jdField_a_of_type_Lfw == null)
      {
        jdField_a_of_type_Lfw = new lfw();
        jdField_a_of_type_Lfw.a();
      }
      return jdField_a_of_type_Lfw;
    }
    finally {}
  }
  
  private void a() {}
  
  public lld a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Lld == null) {
          this.jdField_a_of_type_Lld = lld.a(llf.a(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("getMediaCodecChipConfigInfo content:=");
          if (this.jdField_a_of_type_Lld != null)
          {
            localObject1 = this.jdField_a_of_type_Lld.toString();
            QLog.d("MediaCodecChipConfigManager", 2, (String)localObject1);
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Lld;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public void a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent");
    }
    paramConfigRsp = lld.a(paramConfigRsp);
    try
    {
      String str = paramConfigRsp.a();
      if (QLog.isColorLevel()) {
        QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent jsonContent:=" + str);
      }
      llf.a(str, BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config");
      this.jdField_a_of_type_Lld = paramConfigRsp;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfw
 * JD-Core Version:    0.7.0.1
 */