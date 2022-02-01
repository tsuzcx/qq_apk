package dov.com.qq.im.aeeditor.manage;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager
{
  private static volatile AEEditorEffectConfigManager jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private AEEditorEffectConfigManager.IEffectGroupListBack jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager$IEffectGroupListBack;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private AEEditorEffectConfigManager()
  {
    AEQLog.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static AEEditorEffectConfigManager a()
  {
    if (jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager == null) {
        jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager = new AEEditorEffectConfigManager();
      }
      return jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager;
    }
    finally {}
  }
  
  public static String a()
  {
    return AEEditorPath.EDITOR.FILES.f + File.separator + "effect_group_list.json";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(AEEditorEffectConfigManager.IEffectGroupListBack paramIEffectGroupListBack)
  {
    this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorEffectConfigManager$IEffectGroupListBack = paramIEffectGroupListBack;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager
 * JD-Core Version:    0.7.0.1
 */