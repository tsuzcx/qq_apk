import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.PatchSecurityMode;
import com.tencent.hotpatch.config.BasePatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;

public final class qnm
  implements Runnable
{
  public qnm(Context paramContext, BasePatchConfig paramBasePatchConfig) {}
  
  public void run()
  {
    int i = PatchSharedPreUtil.b(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, this.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c);
    if (i <= 5) {
      PatchSharedPreUtil.b(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, this.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c, i + 1);
    }
    PatchConfigManager.a(this.jdField_a_of_type_AndroidContentContext, "dex", this.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig);
    if ((501 == DexPatchInstaller.a) || (502 == DexPatchInstaller.a))
    {
      i = PatchSharedPreUtil.a(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, this.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c);
      PatchSharedPreUtil.a(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, this.jdField_a_of_type_ComTencentHotpatchConfigBasePatchConfig.c, i + 1);
    }
    while ((500 != DexPatchInstaller.a) || (!PatchSecurityMode.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    PatchSecurityMode.a(this.jdField_a_of_type_AndroidContentContext, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     qnm
 * JD-Core Version:    0.7.0.1
 */