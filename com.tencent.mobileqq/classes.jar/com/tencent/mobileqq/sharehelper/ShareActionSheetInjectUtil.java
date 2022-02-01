package com.tencent.mobileqq.sharehelper;

import com.tencent.mobileqq.app.avgameshare.AVGameShareEntry;
import com.tencent.mobileqq.app.avgameshare.AVGameShareH5Entry;
import com.tencent.mobileqq.app.avgameshare.AVGameShareResultLink;
import com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.HashMap;

public class ShareActionSheetInjectUtil
{
  @ConfigInject(configPath="Business/qqactionsheet/src/main/resources/Inject_actionsheet_share_config.yml", version=1)
  public static HashMap<String, Class<? extends IShareBusinessInterface>> a = new HashMap();
  @ConfigInject(configPath="Business/qqactionsheet/src/main/resources/Inject_actionsheet_share_config.yml", version=1)
  public static ArrayList<Class<? extends IShareActionInterface>> b;
  
  static
  {
    a.put("avShareResultPic", AVGameShareResultPic.class);
    a.put("avShareResultLink", AVGameShareResultLink.class);
    a.put("avShareH5Entry", AVGameShareH5Entry.class);
    a.put("avShareEntry", AVGameShareEntry.class);
    b = new ArrayList();
    b.add(ShareActionSheetInject.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.ShareActionSheetInjectUtil
 * JD-Core Version:    0.7.0.1
 */