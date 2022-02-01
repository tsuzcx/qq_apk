package com.tencent.mobileqq.friend.status;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class OnlineStatusIconHelper
{
  private static OnlineStatusIconHelper jdField_a_of_type_ComTencentMobileqqFriendStatusOnlineStatusIconHelper;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private OnlineStatusIconHelper(Context paramContext)
  {
    a(paramContext);
  }
  
  public static OnlineStatusIconHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFriendStatusOnlineStatusIconHelper == null) {
        jdField_a_of_type_ComTencentMobileqqFriendStatusOnlineStatusIconHelper = new OnlineStatusIconHelper(BaseApplication.getContext());
      }
      return jdField_a_of_type_ComTencentMobileqqFriendStatusOnlineStatusIconHelper;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      OnlineStatusIconHelper.ConfigParser localConfigParser = new OnlineStatusIconHelper.ConfigParser(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localConfigParser);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (paramInt == 3) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.status.OnlineStatusIconHelper
 * JD-Core Version:    0.7.0.1
 */