package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import java.io.File;
import java.io.IOException;

class TroopAvatarWallPreviewActivity$22
  extends AsyncTask<Void, Void, String>
{
  TroopAvatarWallPreviewActivity$22(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      String str1 = this.a.saveTo(this.b);
      if (str1 != null)
      {
        paramVarArgs = null;
        try
        {
          String str2 = MimeTypeMap.getFileExtensionFromUrl(str1);
          if (str2 != null) {
            paramVarArgs = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
          }
          if ((paramVarArgs != null) && (paramVarArgs.startsWith("image/"))) {
            ImageUtil.a(this.c, new File(str1));
          }
        }
        catch (IllegalArgumentException paramVarArgs)
        {
          QLog.e("TroopAvatarWallPreviewActivity", 2, new Object[] { "savePic2SystemMedia illegalArgumentException ex", paramVarArgs.getMessage() });
        }
        ImageUtil.b(this.c, str1);
        if (this.c.getIntent().getBooleanExtra("from_photo_wall", false)) {
          return HardCodeUtil.a(2131912488);
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.c.getString(2131892639));
        paramVarArgs.append(" ");
        paramVarArgs.append(str1);
        return paramVarArgs.toString();
      }
      paramVarArgs = this.c.getString(2131892637);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      break label181;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label171:
      label181:
      break label171;
    }
    return this.c.getString(2131892637);
    return this.c.getString(2131892637);
  }
  
  protected void a(String paramString)
  {
    QQToast.makeText(this.c, paramString, 0).show(this.c.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.22
 * JD-Core Version:    0.7.0.1
 */