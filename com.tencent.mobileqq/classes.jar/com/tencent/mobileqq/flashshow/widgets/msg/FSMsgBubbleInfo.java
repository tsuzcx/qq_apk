package com.tencent.mobileqq.flashshow.widgets.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSInnerProtoUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qflash.QFlashBadge.BadgeAvatarInfo;
import qflash.QFlashBadge.BadgeDisplayInfo;
import qflash.QFlashBadge.BadgeJumpInfo;
import qflash.QFlashBadge.QFlashBadgeContentInfo;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FSMsgBubbleInfo
{
  private final List<String> a = new ArrayList();
  private String b = null;
  private String c = null;
  private String d;
  
  public FSMsgBubbleInfo(FSRedPointData paramFSRedPointData)
  {
    paramFSRedPointData = a(paramFSRedPointData);
    a(paramFSRedPointData);
    int i = paramFSRedPointData.number.get();
    this.b = paramFSRedPointData.wording.get();
    if (TextUtils.isEmpty(this.b)) {
      this.b = String.format(FSHardCodeUtil.a(2131889729), new Object[] { Integer.valueOf(i) });
    }
    this.c = paramFSRedPointData.jumpInfo.jumpLink.get();
  }
  
  private QFlashBadge.BadgeDisplayInfo a(FSRedPointData paramFSRedPointData)
  {
    return (QFlashBadge.BadgeDisplayInfo)FSInnerProtoUtil.a(paramFSRedPointData.getBadgeInfoByte()).contentInfo.displayInfo.get();
  }
  
  private void a(QFlashBadge.BadgeDisplayInfo paramBadgeDisplayInfo)
  {
    this.a.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBadgeDisplayInfo == null) {
      return;
    }
    paramBadgeDisplayInfo = paramBadgeDisplayInfo.avatarInfoList.get().iterator();
    while (paramBadgeDisplayInfo.hasNext())
    {
      QFlashBadge.BadgeAvatarInfo localBadgeAvatarInfo = (QFlashBadge.BadgeAvatarInfo)paramBadgeDisplayInfo.next();
      if (localBadgeAvatarInfo != null)
      {
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(localBadgeAvatarInfo.uID.get());
        if (!TextUtils.isEmpty(localBadgeAvatarInfo.uRL.get())) {
          this.a.add(localBadgeAvatarInfo.uRL.get());
        } else if (!TextUtils.isEmpty(localBadgeAvatarInfo.uID.get())) {
          this.a.add(localBadgeAvatarInfo.uID.get());
        }
      }
    }
    this.d = localStringBuilder.toString();
  }
  
  public List<String> a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.a.size() > 0) || (!TextUtils.isEmpty(this.b));
  }
  
  public String e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.msg.FSMsgBubbleInfo
 * JD-Core Version:    0.7.0.1
 */