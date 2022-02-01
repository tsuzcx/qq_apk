package dov.com.qq.im.aeeditor.manage;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class AEEditorEffectIpcModule
  extends QIPCModule
{
  private static volatile AEEditorEffectIpcModule jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectIpcModule;
  private static boolean jdField_a_of_type_Boolean = false;
  
  private AEEditorEffectIpcModule()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static AEEditorEffectIpcModule a()
  {
    if (jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectIpcModule == null) {}
    try
    {
      if (jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectIpcModule == null) {
        jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectIpcModule = new AEEditorEffectIpcModule();
      }
      return jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectIpcModule;
    }
    finally {}
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      QIPCClientHelper.getInstance().getClient().registerModule(a());
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_effect_list".equals(paramString)) {
      AEEditorEffectConfigManager.a().a(new AEEditorEffectIpcModule.1(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectIpcModule
 * JD-Core Version:    0.7.0.1
 */