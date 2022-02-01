import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lfq
{
  private static lfq jdField_a_of_type_Lfq;
  private lkx jdField_a_of_type_Lkx;
  
  private lfq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
    }
  }
  
  public static lfq a()
  {
    if (jdField_a_of_type_Lfq == null) {}
    try
    {
      if (jdField_a_of_type_Lfq == null)
      {
        jdField_a_of_type_Lfq = new lfq();
        jdField_a_of_type_Lfq.a();
      }
      return jdField_a_of_type_Lfq;
    }
    finally {}
  }
  
  private void a() {}
  
  public lkx a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Lkx == null) {
          this.jdField_a_of_type_Lkx = lkx.a(lkz.a(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("getMediaCodecChipConfigInfo content:=");
          if (this.jdField_a_of_type_Lkx != null)
          {
            localObject1 = this.jdField_a_of_type_Lkx.toString();
            QLog.d("MediaCodecChipConfigManager", 2, (String)localObject1);
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Lkx;
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
    paramConfigRsp = lkx.a(paramConfigRsp);
    try
    {
      String str = paramConfigRsp.a();
      if (QLog.isColorLevel()) {
        QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent jsonContent:=" + str);
      }
      lkz.a(str, BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config");
      this.jdField_a_of_type_Lkx = paramConfigRsp;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfq
 * JD-Core Version:    0.7.0.1
 */