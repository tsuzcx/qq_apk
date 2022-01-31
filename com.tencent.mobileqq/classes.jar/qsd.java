import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.PatchSecurityMode;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;

public final class qsd
  implements Runnable
{
  public qsd(PatchConfig paramPatchConfig, Context paramContext) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig.b();
    int i = PatchSharedPreUtil.b(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str);
    if (i <= 5) {
      PatchSharedPreUtil.b(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str, i + 1);
    }
    PatchConfigManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentHotpatchConfigPatchConfig);
    if ((501 == DexPatchInstaller.a) || (502 == DexPatchInstaller.a))
    {
      i = PatchSharedPreUtil.a(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str);
      PatchSharedPreUtil.a(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str, i + 1);
    }
    while ((500 != DexPatchInstaller.a) || (!PatchSecurityMode.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    PatchSecurityMode.a(this.jdField_a_of_type_AndroidContentContext, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     qsd
 * JD-Core Version:    0.7.0.1
 */