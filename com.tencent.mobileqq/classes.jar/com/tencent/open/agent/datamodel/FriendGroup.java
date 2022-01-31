package com.tencent.open.agent.datamodel;

import alkn;
import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.open.base.StringAddition;
import com.tencent.open.component.cache.database.DbCacheData;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FriendGroup
  extends DbCacheData
{
  public static final DbCacheData.DbCreator a;
  public int a;
  public String a;
  public List a;
  public int b;
  
  static
  {
    jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator = new alkn();
  }
  
  public FriendGroup()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
  }
  
  public static final List a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("qqlist");
    int k = paramJSONObject.optInt("app_tid", -1);
    int m = paramJSONObject.optInt("app_rid", -1);
    int n = localJSONArray1.length();
    ArrayList localArrayList1 = new ArrayList(n);
    int i = 0;
    while (i < n)
    {
      JSONObject localJSONObject = localJSONArray1.getJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject.getJSONArray("data");
      int i1 = localJSONArray2.length();
      ArrayList localArrayList2 = new ArrayList(i1);
      int j = 0;
      if (j < i1)
      {
        Object localObject = localJSONArray2.getJSONObject(j);
        String str = ((JSONObject)localObject).getString("data");
        if (((JSONObject)localObject).has("nick"))
        {
          paramJSONObject = ((JSONObject)localObject).getString("nick");
          label129:
          if (!((JSONObject)localObject).has("label")) {
            break label216;
          }
        }
        label216:
        for (localObject = ((JSONObject)localObject).getString("label");; localObject = null)
        {
          Friend localFriend = new Friend();
          localFriend.jdField_a_of_type_JavaLangString = str;
          localFriend.jdField_b_of_type_JavaLangString = StringAddition.a(paramJSONObject);
          localFriend.jdField_c_of_type_JavaLangString = StringAddition.a((String)localObject);
          localFriend.jdField_b_of_type_Int = m;
          localFriend.jdField_c_of_type_Int = k;
          localArrayList2.add(localFriend);
          j += 1;
          break;
          paramJSONObject = null;
          break label129;
        }
      }
      paramJSONObject = new FriendGroup();
      paramJSONObject.jdField_a_of_type_Int = i;
      paramJSONObject.jdField_a_of_type_JavaLangString = StringAddition.a(localJSONObject.getString("label"));
      paramJSONObject.jdField_a_of_type_JavaUtilList = localArrayList2;
      localArrayList1.add(paramJSONObject);
      i += 1;
    }
    return localArrayList1;
  }
  
  public static final List b(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("data");
    int m = localJSONArray1.length();
    int n = paramJSONObject.optInt("app_tid", -1);
    int i1 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList(m + 3);
    ArrayList localArrayList2 = new ArrayList();
    FriendGroup localFriendGroup = new FriendGroup();
    localFriendGroup.jdField_a_of_type_Int = 0;
    localFriendGroup.jdField_a_of_type_JavaLangString = "推荐好友";
    localFriendGroup.jdField_a_of_type_JavaUtilList = localArrayList2;
    localArrayList1.add(localFriendGroup);
    int j = 0;
    int i = 1;
    while (j < m)
    {
      JSONObject localJSONObject1 = localJSONArray1.getJSONObject(j);
      JSONArray localJSONArray2 = localJSONObject1.getJSONArray("friends");
      int i2 = localJSONArray2.length();
      ArrayList localArrayList3 = new ArrayList(i2);
      int k = 0;
      while (k < i2)
      {
        JSONObject localJSONObject2 = localJSONArray2.getJSONObject(k);
        if (localJSONObject2.getInt("unabled") == 1)
        {
          k += 1;
        }
        else
        {
          String str2 = localJSONObject2.getString("openid");
          if (localJSONObject2.has("nickname"))
          {
            localObject = localJSONObject2.getString("nickname");
            label199:
            if (!localJSONObject2.has("remark")) {
              break label304;
            }
          }
          label304:
          for (String str1 = localJSONObject2.getString("remark");; str1 = null)
          {
            Friend localFriend = new Friend();
            localFriend.jdField_a_of_type_JavaLangString = str2;
            localFriend.jdField_b_of_type_JavaLangString = StringAddition.a((String)localObject);
            localFriend.jdField_c_of_type_JavaLangString = StringAddition.a(str1);
            if (localJSONObject2.getInt("specified") == 1)
            {
              localFriend.jdField_b_of_type_Int = i1;
              localFriend.jdField_c_of_type_Int = n;
              localArrayList2.add(localFriend);
            }
            localArrayList3.add(localFriend);
            break;
            localObject = null;
            break label199;
          }
        }
      }
      Object localObject = new FriendGroup();
      ((FriendGroup)localObject).jdField_a_of_type_Int = i;
      ((FriendGroup)localObject).jdField_a_of_type_JavaLangString = StringAddition.a(localJSONObject1.getString("groupname"));
      ((FriendGroup)localObject).jdField_a_of_type_JavaUtilList = localArrayList3;
      localArrayList1.add(localObject);
      j += 1;
      i += 1;
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList(1);
      paramJSONObject.add(localFriendGroup);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      localArrayList1.remove(0);
      i = 0;
      while (i < localArrayList1.size())
      {
        paramJSONObject = (FriendGroup)localArrayList1.get(i);
        paramJSONObject.jdField_a_of_type_Int -= 1;
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public static final List c(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("qqlist");
    int m = localJSONArray1.length();
    int n = paramJSONObject.optInt("app_tid", -1);
    int i1 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FriendGroup localFriendGroup2 = new FriendGroup();
    localFriendGroup2.jdField_a_of_type_Int = 0;
    localFriendGroup2.jdField_a_of_type_JavaLangString = "推荐好友";
    localFriendGroup2.jdField_a_of_type_JavaUtilList = localArrayList2;
    localArrayList1.add(localFriendGroup2);
    int i = 0;
    FriendGroup localFriendGroup1 = null;
    int j = 1;
    if (i < m)
    {
      JSONObject localJSONObject1 = localJSONArray1.getJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject1.getJSONArray("data");
      int i2 = localJSONArray2.length();
      ArrayList localArrayList3 = new ArrayList();
      int k = 0;
      Object localObject;
      if (k < i2)
      {
        JSONObject localJSONObject2 = localJSONArray2.getJSONObject(k);
        String str2 = localJSONObject2.getString("data");
        if (localJSONObject2.has("nick"))
        {
          localObject = localJSONObject2.getString("nick");
          label178:
          if (!localJSONObject2.has("label")) {
            break label291;
          }
        }
        label291:
        for (String str1 = localJSONObject2.getString("label");; str1 = null)
        {
          Friend localFriend = new Friend();
          localFriend.jdField_a_of_type_JavaLangString = str2;
          localFriend.jdField_b_of_type_JavaLangString = ((String)localObject);
          localFriend.jdField_c_of_type_JavaLangString = str1;
          if ((localJSONObject2.getInt("specified") == 1) && (!localArrayList2.contains(localFriend)))
          {
            localFriend.jdField_b_of_type_Int = i1;
            localFriend.jdField_c_of_type_Int = n;
            localArrayList2.add(localFriend);
          }
          localArrayList3.add(localFriend);
          k += 1;
          break;
          localObject = null;
          break label178;
        }
      }
      if ("推荐好友".equals(localJSONObject1.getString("label")))
      {
        localFriendGroup1 = new FriendGroup();
        localFriendGroup1.jdField_a_of_type_Int = 0;
        localFriendGroup1.jdField_a_of_type_JavaLangString = StringAddition.a(localJSONObject1.getString("label"));
        localFriendGroup1.jdField_a_of_type_JavaUtilList = localArrayList3;
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = new FriendGroup();
        ((FriendGroup)localObject).jdField_a_of_type_Int = j;
        ((FriendGroup)localObject).jdField_a_of_type_JavaLangString = StringAddition.a(localJSONObject1.getString("label"));
        ((FriendGroup)localObject).jdField_a_of_type_JavaUtilList = localArrayList3;
        localArrayList1.add(localObject);
        j += 1;
      }
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList();
      paramJSONObject.add(localFriendGroup2);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      if ((localFriendGroup1 == null) || (localFriendGroup1.jdField_a_of_type_JavaUtilList == null) || (localFriendGroup1.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label487;
      }
      localArrayList1.remove(0);
      localArrayList1.add(0, localFriendGroup1);
    }
    for (;;)
    {
      return localArrayList1;
      label487:
      localArrayList1.remove(0);
      i = 0;
      while (i < localArrayList1.size())
      {
        paramJSONObject = (FriendGroup)localArrayList1.get(i);
        paramJSONObject.jdField_a_of_type_Int -= 1;
        i += 1;
      }
    }
  }
  
  public void a(ContentValues paramContentValues)
  {
    Parcel localParcel = Parcel.obtain();
    b(localParcel);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("data", arrayOfByte);
    paramContentValues.put("groupId", Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, Friend.CREATOR);
  }
  
  public void b(Parcel paramParcel)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.FriendGroup
 * JD-Core Version:    0.7.0.1
 */