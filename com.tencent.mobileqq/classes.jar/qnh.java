import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PkgInstallInfo;

public class qnh
{
  public int a;
  public String a;
  public boolean a;
  
  public qnh()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public oidb_cmd0x68b.PkgInstallInfo a()
  {
    int i = 1;
    oidb_cmd0x68b.PkgInstallInfo localPkgInstallInfo = new oidb_cmd0x68b.PkgInstallInfo();
    localPkgInstallInfo.uint32_platform_type.set(1);
    PBUInt32Field localPBUInt32Field = localPkgInstallInfo.uint32_is_installed;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
      }
      return localPkgInstallInfo;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnh
 * JD-Core Version:    0.7.0.1
 */