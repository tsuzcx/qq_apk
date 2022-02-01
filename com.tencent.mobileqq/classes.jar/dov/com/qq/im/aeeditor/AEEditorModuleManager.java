package dov.com.qq.im.aeeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.arch.IAEEditor;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AEEditorModuleManager
  implements IAEEditor
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorModuleManager.class.getSimpleName();
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private HashMap<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> jdField_a_of_type_JavaUtilHashMap;
  
  public AEEditorModuleManager(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private AEEditorBaseFragment a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((AEEditorBaseFragment)localEntry.getValue()).isVisible()) {
        return (AEEditorBaseFragment)localEntry.getValue();
      }
    }
    return null;
  }
  
  private void a(AEEditorBaseFragment paramAEEditorBaseFragment, Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramClass)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramClass) == null)) {}
    AEEditorBaseFragment localAEEditorBaseFragment;
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        localAEEditorBaseFragment = (AEEditorBaseFragment)paramClass.newInstance();
        localAEEditorBaseFragment.a(this);
        if (localAEEditorBaseFragment.getArguments() != null) {
          break label227;
        }
        localAEEditorBaseFragment.setArguments(paramBundle);
        localAEEditorBaseFragment.jdField_a_of_type_JavaLangString = paramString;
        paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
        paramString = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        if ((!paramBoolean1) || (paramAEEditorBaseFragment == null) || (!((AEEditorBaseFragment)localEntry.getValue()).equals(paramAEEditorBaseFragment))) {
          break label240;
        }
        paramString = (Class)localEntry.getKey();
        continue;
        localAEEditorBaseFragment = (AEEditorBaseFragment)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass);
      }
      catch (IllegalAccessException paramAEEditorBaseFragment)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "replaceFragment: " + Log.getStackTraceString(paramAEEditorBaseFragment));
        return;
      }
      catch (InstantiationException paramAEEditorBaseFragment)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "replaceFragment: " + Log.getStackTraceString(paramAEEditorBaseFragment));
        return;
      }
      localAEEditorBaseFragment.a(this);
      continue;
      label227:
      localAEEditorBaseFragment.getArguments().putAll(paramBundle);
      continue;
      label240:
      paramBundle.hide((Fragment)localEntry.getValue());
    }
    if ((paramBoolean1) && (paramAEEditorBaseFragment != null))
    {
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      paramBundle.remove(paramAEEditorBaseFragment);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(paramClass.getName()) == null) {
      paramBundle.add(2131362325, localAEEditorBaseFragment, paramClass.getName()).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass, localAEEditorBaseFragment);
      return;
      paramBundle.show(localAEEditorBaseFragment).commit();
    }
  }
  
  private void a(Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle)
  {
    a(null, paramClass, paramString, paramBundle, false, false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEEditorBaseFragment localAEEditorBaseFragment = a();
    if (localAEEditorBaseFragment != null) {
      localAEEditorBaseFragment.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    AEEditorBaseFragment localAEEditorBaseFragment;
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return;
          localAEEditorBaseFragment = a();
        } while (localAEEditorBaseFragment == null);
        boolean bool2 = false;
        bool1 = bool2;
        if (localAEEditorBaseFragment.isVisible())
        {
          bool1 = bool2;
          if (paramBoolean) {
            bool1 = false | localAEEditorBaseFragment.a();
          }
        }
      } while (bool1);
      try
      {
        localAEEditorBaseFragment.a();
        if (localAEEditorBaseFragment.jdField_a_of_type_JavaLangString == null)
        {
          AEQLog.b(jdField_a_of_type_JavaLangString, "goBack finish activity");
          b(paramActivity);
          paramActivity.finish();
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(paramActivity));
        return;
      }
      if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorVideoEdit")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoClip")))
      {
        b(null, new Bundle(localAEEditorBaseFragment.getArguments()));
        return;
      }
      if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorMultiVideoEdit")) && (localAEEditorBaseFragment.a().equals("AEEditorMultiCutFragment")))
      {
        c(null, new Bundle(localAEEditorBaseFragment.getArguments()));
        return;
      }
      if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorImageEdit")) && ((localAEEditorBaseFragment.a().equals("AEEditorMultiVideoEdit")) || (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit"))))
      {
        a(null, new Bundle(localAEEditorBaseFragment.getArguments()));
        return;
      }
      if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment")) && (localAEEditorBaseFragment.a().equals("AEEditorMultiVideoEdit")))
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "goBack finish activity");
        b(paramActivity);
        paramActivity.finish();
        return;
      }
    } while ((!localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorVideoClip")) || (!localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")));
    AEQLog.b(jdField_a_of_type_JavaLangString, "goBack finish activity");
    b(paramActivity);
    paramActivity.finish();
  }
  
  public void a(Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "enter");
    if (AEEditorLauncher.a(paramBundle))
    {
      a(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.b(paramBundle))
    {
      b(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.c(paramBundle))
    {
      c(null, paramBundle);
      return;
    }
    throw new RuntimeException("invalid editor type");
  }
  
  public void a(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "gotoVideoClipModule from " + paramString);
    a(paramAEEditorBaseFragment, AEEditorVideoClipFragment.class, paramString, paramBundle, false, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "gotoImageEditModule from " + paramString);
    a(AEEditorImageEditFragment.class, paramString, paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    AEEditorBaseFragment localAEEditorBaseFragment = a();
    if (localAEEditorBaseFragment != null) {
      localAEEditorBaseFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.finish();
  }
  
  public void b(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "gotoMultiCutEditModule from" + paramString);
    a(paramAEEditorBaseFragment, AEEditorMultiCutEditFragment.class, paramString, paramBundle, false, true);
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "gotoVideoEditModule from " + paramString);
    a(AEEditorVideoEditFragment.class, paramString, paramBundle);
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "gotoMultiVideoEditModule from " + paramString);
    a(AEEditorMultiVideoEditFragment.class, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorModuleManager
 * JD-Core Version:    0.7.0.1
 */