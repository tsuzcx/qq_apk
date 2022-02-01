package com.tencent.open.agent.datamodel;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  public static final DbCacheData.DbCreator<FriendGroup> e = new FriendGroup.1();
  public int a = -1;
  public String b = "";
  public List<Friend> c;
  public int d = -1;
  
  public static final List<FriendGroup> a(JSONObject paramJSONObject)
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
      while (j < i1)
      {
        Object localObject = localJSONArray2.getJSONObject(j);
        String str2 = ((JSONObject)localObject).getString("data");
        boolean bool = ((JSONObject)localObject).has("nick");
        String str1 = null;
        if (bool) {
          paramJSONObject = ((JSONObject)localObject).getString("nick");
        } else {
          paramJSONObject = null;
        }
        if (((JSONObject)localObject).has("label")) {
          str1 = ((JSONObject)localObject).getString("label");
        }
        localObject = new Friend();
        ((Friend)localObject).a = str2;
        ((Friend)localObject).b = StringAddition.a(paramJSONObject);
        ((Friend)localObject).c = StringAddition.a(str1);
        ((Friend)localObject).g = m;
        ((Friend)localObject).h = k;
        localArrayList2.add(localObject);
        j += 1;
      }
      paramJSONObject = new FriendGroup();
      paramJSONObject.a = i;
      paramJSONObject.b = StringAddition.a(localJSONObject.getString("label"));
      paramJSONObject.c = localArrayList2;
      localArrayList1.add(paramJSONObject);
      i += 1;
    }
    return localArrayList1;
  }
  
  public static final List<FriendGroup> b(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("data");
    int i = localJSONArray.length();
    int n = paramJSONObject.optInt("app_tid", -1);
    int i1 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList(i + 3);
    ArrayList localArrayList2 = new ArrayList();
    FriendGroup localFriendGroup = new FriendGroup();
    localFriendGroup.a = 0;
    localFriendGroup.b = HardCodeUtil.a(2131902862);
    localFriendGroup.c = localArrayList2;
    localArrayList1.add(localFriendGroup);
    int k = 0;
    int j = 1;
    for (;;)
    {
      int m = 0;
      if (k >= i) {
        break;
      }
      JSONObject localJSONObject1 = localJSONArray.getJSONObject(k);
      Object localObject = localJSONObject1.getJSONArray("friends");
      int i2 = ((JSONArray)localObject).length();
      ArrayList localArrayList3 = new ArrayList(i2);
      while (m < i2)
      {
        JSONObject localJSONObject2 = ((JSONArray)localObject).getJSONObject(m);
        if (localJSONObject2.getInt("unabled") != 1)
        {
          String str3 = localJSONObject2.getString("openid");
          boolean bool = localJSONObject2.has("nickname");
          String str2 = null;
          String str1;
          if (bool) {
            str1 = localJSONObject2.getString("nickname");
          } else {
            str1 = null;
          }
          if (localJSONObject2.has("remark")) {
            str2 = localJSONObject2.getString("remark");
          }
          Friend localFriend = new Friend();
          localFriend.a = str3;
          localFriend.b = StringAddition.a(str1);
          localFriend.c = StringAddition.a(str2);
          if (localJSONObject2.getInt("specified") == 1)
          {
            localFriend.g = i1;
            localFriend.h = n;
            localArrayList2.add(localFriend);
          }
          localArrayList3.add(localFriend);
        }
        m += 1;
      }
      localObject = new FriendGroup();
      ((FriendGroup)localObject).a = j;
      ((FriendGroup)localObject).b = StringAddition.a(localJSONObject1.getString("groupname"));
      ((FriendGroup)localObject).c = localArrayList3;
      localArrayList1.add(localObject);
      k += 1;
      j += 1;
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList(1);
      paramJSONObject.add(localFriendGroup);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      i = 0;
      localArrayList1.remove(0);
      while (i < localArrayList1.size())
      {
        paramJSONObject = (FriendGroup)localArrayList1.get(i);
        paramJSONObject.a -= 1;
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public static final List<FriendGroup> c(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("qqlist");
    int i = localJSONArray1.length();
    int i1 = paramJSONObject.optInt("app_tid", -1);
    int i2 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FriendGroup localFriendGroup2 = new FriendGroup();
    localFriendGroup2.a = 0;
    localFriendGroup2.b = HardCodeUtil.a(2131902861);
    localFriendGroup2.c = localArrayList2;
    localArrayList1.add(localFriendGroup2);
    int j = 0;
    FriendGroup localFriendGroup1 = null;
    int k = 1;
    while (j < i)
    {
      JSONObject localJSONObject1 = localJSONArray1.getJSONObject(j);
      Object localObject = "data";
      JSONArray localJSONArray2 = localJSONObject1.getJSONArray("data");
      int m = localJSONArray2.length();
      ArrayList localArrayList3 = new ArrayList();
      int n = 0;
      while (n < m)
      {
        JSONObject localJSONObject2 = localJSONArray2.getJSONObject(n);
        String str3 = localJSONObject2.getString((String)localObject);
        String str1;
        if (localJSONObject2.has("nick")) {
          str1 = localJSONObject2.getString("nick");
        } else {
          str1 = null;
        }
        String str2;
        if (localJSONObject2.has("label")) {
          str2 = localJSONObject2.getString("label");
        } else {
          str2 = null;
        }
        Friend localFriend = new Friend();
        localFriend.a = str3;
        localFriend.b = str1;
        localFriend.c = str2;
        if ((localJSONObject2.getInt("specified") == 1) && (!localArrayList2.contains(localFriend)))
        {
          localFriend.g = i2;
          localFriend.h = i1;
          localArrayList2.add(localFriend);
        }
        localArrayList3.add(localFriend);
        n += 1;
      }
      if (HardCodeUtil.a(2131902860).equals(localJSONObject1.getString("label")))
      {
        localFriendGroup1 = new FriendGroup();
        localFriendGroup1.a = 0;
        localFriendGroup1.b = StringAddition.a(localJSONObject1.getString("label"));
        localFriendGroup1.c = localArrayList3;
      }
      else
      {
        localObject = new FriendGroup();
        ((FriendGroup)localObject).a = k;
        ((FriendGroup)localObject).b = StringAddition.a(localJSONObject1.getString("label"));
        ((FriendGroup)localObject).c = localArrayList3;
        localArrayList1.add(localObject);
        k += 1;
      }
      j += 1;
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList();
      paramJSONObject.add(localFriendGroup2);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      if (localFriendGroup1 != null)
      {
        paramJSONObject = localFriendGroup1.c;
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          localArrayList1.remove(0);
          localArrayList1.add(0, localFriendGroup1);
          return localArrayList1;
        }
      }
      i = 0;
      localArrayList1.remove(0);
      while (i < localArrayList1.size())
      {
        paramJSONObject = (FriendGroup)localArrayList1.get(i);
        paramJSONObject.a -= 1;
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public void a(ContentValues paramContentValues)
  {
    Parcel localParcel = Parcel.obtain();
    b(localParcel);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("data", arrayOfByte);
    paramContentValues.put("groupId", Integer.valueOf(this.a));
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = new ArrayList();
    paramParcel.readTypedList(this.c, Friend.CREATOR);
  }
  
  public void b(Parcel paramParcel)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.FriendGroup
 * JD-Core Version:    0.7.0.1
 */