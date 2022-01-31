package dov.com.tencent.biz.qqstory.takevideo.music;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.io.File;

public class QQStoryBGMusicUtils
{
  public static final String a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 86400000) {
      return "unknow";
    }
    int i = (int)Math.floor(paramInt / 3600000);
    int j = (int)Math.floor(paramInt % 3600000) / 60000;
    if (paramBoolean) {}
    for (paramInt = Math.round(paramInt % 60000 / 1000.0F); i > 0; paramInt = (int)Math.floor(paramInt % 60000 / 1000)) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
  }
  
  public static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("MusicComposeDialog.createMusicFilePath() musicUrl is null!!!!");
    }
    File localFile = new File(QQStoryConstant.d);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString = QQStoryConstant.d + MD5.a(paramString) + "." + FileUtils.c(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "createMusicFilePath destPath = " + paramString);
    }
    return paramString;
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://y.qq.com/m/qzonemusic/mqzsearch.html?_wv=3&_bid=203&entry=buluo&uin=%s", new Object[] { QQStoryContext.a().a() }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramBaseActivity.startActivityForResult(localIntent, 1000);
    paramBaseActivity.overridePendingTransition(2131034123, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils
 * JD-Core Version:    0.7.0.1
 */