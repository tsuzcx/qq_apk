import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lfk
{
  private static lfk jdField_a_of_type_Lfk;
  private lkr jdField_a_of_type_Lkr;
  
  private lfk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
    }
  }
  
  public static lfk a()
  {
    if (jdField_a_of_type_Lfk == null) {}
    try
    {
      if (jdField_a_of_type_Lfk == null)
      {
        jdField_a_of_type_Lfk = new lfk();
        jdField_a_of_type_Lfk.a();
      }
      return jdField_a_of_type_Lfk;
    }
    finally {}
  }
  
  private void a() {}
  
  public lkr a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Lkr == null) {
          this.jdField_a_of_type_Lkr = lkr.a(lkt.a(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("getMediaCodecChipConfigInfo content:=");
          if (this.jdField_a_of_type_Lkr != null)
          {
            localObject1 = this.jdField_a_of_type_Lkr.toString();
            QLog.d("MediaCodecChipConfigManager", 2, (String)localObject1);
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Lkr;
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
    paramConfigRsp = lkr.a(paramConfigRsp);
    try
    {
      String str = paramConfigRsp.a();
      if (QLog.isColorLevel()) {
        QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent jsonContent:=" + str);
      }
      lkt.a(str, BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config");
      this.jdField_a_of_type_Lkr = paramConfigRsp;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */