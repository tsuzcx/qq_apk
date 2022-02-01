package dov.com.qq.im.aeeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AEEditorLauncher
{
  public static void a(Activity paramActivity, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    int i;
    Intent localIntent;
    if (paramInt1 == 0)
    {
      i = 10000;
      localIntent = new Intent(paramActivity, AEEditorActivity.class);
      if (paramBundle == null) {
        break label173;
      }
    }
    label173:
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      paramBundle.putInt("editorType", paramInt1);
      paramBundle.putInt("editorFrom", paramInt2);
      if (paramActivity.getIntent() != null)
      {
        paramBundle.putString("editor_filter_id", paramActivity.getIntent().getStringExtra("editor_filter_id"));
        paramActivity.getIntent().putExtra("editor_filter_id", "");
      }
      if (paramActivity.getIntent() != null)
      {
        paramBundle.putString("editor_text_sticker_id", paramActivity.getIntent().getStringExtra("editor_text_sticker_id"));
        paramActivity.getIntent().putExtra("editor_text_sticker_id", "");
      }
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, i);
      return;
      if (paramInt1 == 1)
      {
        i = 10001;
        break;
      }
      if ((paramInt1 == 2) || (paramInt1 == 3))
      {
        i = 10002;
        break;
      }
      throw new IllegalArgumentException("wrong editor type");
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return a(paramBundle, 0);
  }
  
  private static boolean a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    while ((!paramBundle.containsKey("editorType")) || (paramBundle.getInt("editorType") != paramInt)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(Bundle paramBundle)
  {
    return a(paramBundle, 1);
  }
  
  public static boolean c(Bundle paramBundle)
  {
    return a(paramBundle, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorLauncher
 * JD-Core Version:    0.7.0.1
 */