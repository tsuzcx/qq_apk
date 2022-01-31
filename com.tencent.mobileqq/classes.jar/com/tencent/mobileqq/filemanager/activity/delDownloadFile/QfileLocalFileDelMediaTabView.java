package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import acqj;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.util.FileUtil;

public class QfileLocalFileDelMediaTabView
  extends QfileLocalFileMediaTabView
{
  public QfileLocalFileDelMediaTabView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public String a(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "其他";
    }
    paramString = paramString.toLowerCase();
    if (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".contains(paramString)) {
      return "视频";
    }
    if (".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|".contains(paramString)) {
      return "音乐";
    }
    return "其他";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new acqj(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView
 * JD-Core Version:    0.7.0.1
 */