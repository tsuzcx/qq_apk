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
  public static ArrayList<Class<? extends IShareActionInterface>> a;
  @ConfigInject(configPath="Business/qqactionsheet/src/main/resources/Inject_actionsheet_share_config.yml", version=1)
  public static HashMap<String, Class<? extends IShareBusinessInterface>> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("avShareResultPic", AVGameShareResultPic.class);
    jdField_a_of_type_JavaUtilHashMap.put("avShareResultLink", AVGameShareResultLink.class);
    jdField_a_of_type_JavaUtilHashMap.put("avShareH5Entry", AVGameShareH5Entry.class);
    jdField_a_of_type_JavaUtilHashMap.put("avShareEntry", AVGameShareEntry.class);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(ShareActionSheetInject.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.ShareActionSheetInjectUtil
 * JD-Core Version:    0.7.0.1
 */