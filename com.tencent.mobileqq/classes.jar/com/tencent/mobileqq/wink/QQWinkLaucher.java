package com.tencent.mobileqq.wink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.mobileqq.wink.utils.QQWinkUtil;

public class QQWinkLaucher
{
  public static void a(Context paramContext)
  {
    QQWinkUtil.a(paramContext);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    paramString = paramIntent;
    if (paramIntent == null) {
      paramString = new Intent();
    }
    paramString.setClass(paramContext, QQWinkActivity.class);
    paramString.putExtra("public_fragment_class", WinkCirclePhotoListFragment.class.getName());
    paramContext.startActivity(paramString);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((paramContext instanceof Activity))
    {
      paramString2 = paramIntent;
      if (paramIntent == null) {
        paramString2 = new Intent();
      }
      paramString2.setClass(paramContext, QQWinkActivity.class);
      paramString2.putExtra("public_fragment_class", WinkCoverSelectFragment.class.getName());
      paramString2.putExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_VIDEO_MISSION_ID(), paramString1);
      ((Activity)paramContext).startActivityForResult(paramString2, paramInt);
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString) {}
  
  public static void b(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((paramContext instanceof Activity))
    {
      paramString2 = paramIntent;
      if (paramIntent == null) {
        paramString2 = new Intent();
      }
      paramString2.setClass(paramContext, QQWinkActivity.class);
      paramString2.putExtra("public_fragment_class", WinkPreviewFragment.class.getName());
      paramString2.putExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_VIDEO_MISSION_ID(), paramString1);
      ((Activity)paramContext).startActivityForResult(paramString2, paramInt);
    }
  }
  
  public static void c(Context paramContext, Intent paramIntent, String paramString) {}
  
  public static void d(Context paramContext, Intent paramIntent, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.QQWinkLaucher
 * JD-Core Version:    0.7.0.1
 */