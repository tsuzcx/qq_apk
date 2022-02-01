package com.tencent.timi.game.component.qqlive.impl.util;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.TgCheckPermissionCallback;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;

public class TgLiveUtils
{
  public static void a(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, TgCheckPermissionCallback paramTgCheckPermissionCallback)
  {
    if (paramQQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
      paramQQLiveAnchorStreamRecordType = TgLiveConstants.a;
    } else {
      paramQQLiveAnchorStreamRecordType = TgLiveConstants.b;
    }
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    if (localQBaseActivity != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramQQLiveAnchorStreamRecordType.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        String str = paramQQLiveAnchorStreamRecordType[i];
        if (localQBaseActivity.checkSelfPermission(str) != 0) {
          localArrayList.add(str);
        }
        i += 1;
      }
      if (localArrayList.size() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramTgCheckPermissionCallback != null) {
          paramTgCheckPermissionCallback.a();
        }
      }
      else
      {
        paramQQLiveAnchorStreamRecordType = new String[localArrayList.size()];
        i = j;
        while (i < localArrayList.size())
        {
          paramQQLiveAnchorStreamRecordType[i] = ((String)localArrayList.get(i));
          i += 1;
        }
        localQBaseActivity.requestPermissions(new TgLiveUtils.1(paramTgCheckPermissionCallback), 10086, paramQQLiveAnchorStreamRecordType);
      }
    }
    else if (paramTgCheckPermissionCallback != null)
    {
      paramTgCheckPermissionCallback.a(-1, "检查权限失败，请退出重试");
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAvFocus - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TgLiveTag_TgLiveUtils", localStringBuilder.toString());
    return true;
  }
  
  public static void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("abandonAvFocus - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TgLiveTag_TgLiveUtils", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils
 * JD-Core Version:    0.7.0.1
 */