package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasFriendInfoHippyHelper
{
  Activity a;
  protected VasFriendInfoHippyHelper.ChooseFriendReceiver a;
  
  public VasFriendInfoHippyHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private Context a()
  {
    for (Activity localActivity = this.jdField_a_of_type_AndroidAppActivity; (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  protected static JSONObject a(Intent paramIntent, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<Integer> paramList4, List<String> paramList5, List<String> paramList6, List<Integer> paramList7, List<Integer> paramList8)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
        {
          i = 0;
          localObject2 = paramList3;
          localObject1 = paramList2;
          paramIntent = paramList1;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
          {
            if (TextUtils.isEmpty((CharSequence)paramIntent.get(i))) {
              break label605;
            }
            paramIntent = (String)paramIntent.get(i);
            if (TextUtils.isEmpty((CharSequence)((List)localObject1).get(i))) {
              break label611;
            }
            localObject1 = (String)((List)localObject1).get(i);
            if (TextUtils.isEmpty((CharSequence)((List)localObject2).get(i))) {
              break label618;
            }
            localObject2 = (String)((List)localObject2).get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", paramIntent);
            localJSONObject2.put("phone", localObject1);
            localJSONObject2.put("name", localObject2);
            if ((paramList4 != null) && (paramList4.size() > i)) {
              localJSONObject2.put("type", paramList4.get(i));
            } else {
              localJSONObject2.put("type", 1);
            }
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        if ((paramList5 == null) || (paramList6 == null) || (paramList7 == null) || (paramList8 == null)) {
          break label671;
        }
        paramList2 = new JSONArray();
        i = 0;
        paramList1 = paramList5;
        paramIntent = paramList2;
        if (i < paramList5.size())
        {
          paramIntent = paramList2;
          if (i < paramList6.size())
          {
            paramIntent = paramList2;
            if (i < paramList7.size())
            {
              paramIntent = paramList2;
              if (i < paramList8.size())
              {
                if (TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
                  break label625;
                }
                paramIntent = (String)paramList1.get(i);
                if (TextUtils.isEmpty((CharSequence)paramList6.get(i))) {
                  break label631;
                }
                paramList1 = (String)paramList6.get(i);
                if (paramList7.get(i) == null) {
                  break label637;
                }
                j = ((Integer)paramList7.get(i)).intValue();
                if (paramList8.get(i) == null) {
                  break label643;
                }
                k = ((Integer)paramList8.get(i)).intValue();
                break label646;
                paramList3 = new JSONObject();
                paramList3.put("uin", paramIntent);
                paramList3.put("name", paramList1);
                paramList3.put("type", k);
                paramList3.put("count", j);
                paramList2.put(paramList3);
                break label662;
              }
            }
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          localJSONObject1.put("groups", paramIntent);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasFriendInfoHippyHelper", 2, localJSONObject1.toString());
        }
        return localJSONObject1;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return null;
      }
      label605:
      paramIntent = "";
      continue;
      label611:
      Object localObject1 = "";
      continue;
      label618:
      Object localObject2 = "";
      continue;
      label625:
      paramIntent = "";
      continue;
      label631:
      paramList1 = "";
      continue;
      label637:
      int j = 0;
      continue;
      label643:
      int k = 0;
      label646:
      if ((k != 4) && (k != 8))
      {
        label662:
        i += 1;
        continue;
        label671:
        paramIntent = null;
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, ArrayList<String> paramArrayList, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Intent paramIntent)
  {
    paramIntent.putExtra("param_donot_need_contacts", true);
    paramIntent.putExtra("param_min", 1);
    paramIntent.putExtra("param_max", paramInt1);
    paramIntent.addFlags(67108864);
    if ((!TextUtils.isEmpty(paramString)) && ((paramInt2 == 4) || (paramInt2 == 8)))
    {
      paramIntent.putExtra("param_entrance", 32);
      paramIntent.putExtra("param_only_friends", false);
      paramIntent.putExtra("param_overload_tips_include_default_count", true);
      paramIntent.putExtra("group_uin", paramString);
      boolean bool;
      if (paramInt3 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.putExtra("param_enable_all_select", bool);
      if (paramInt4 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.putExtra("param_show_myself", bool);
      if (paramInt5 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.putExtra("is_put_myself_first", bool);
      if (paramInt6 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.putExtra("is_forbid_only_choose_myself", bool);
      if (paramArrayList.size() > 0)
      {
        if (paramArrayList.size() > paramInt1)
        {
          paramInt3 = paramArrayList.size() - 1;
          while (paramInt3 >= paramInt1)
          {
            paramArrayList.remove(paramInt3);
            paramInt3 -= 1;
          }
        }
        paramIntent.putExtra("param_uins_selected_friends", paramArrayList);
      }
      if (paramInt2 == 4)
      {
        paramIntent.putExtra("param_only_troop_member", true);
        paramIntent.putExtra("param_only_discussion_member", false);
        return;
      }
      if (paramInt2 == 8)
      {
        paramIntent.putExtra("param_only_troop_member", false);
        paramIntent.putExtra("param_only_discussion_member", true);
      }
    }
    else
    {
      paramIntent.putExtra("param_only_friends", true);
    }
  }
  
  private void a(HippyMap paramHippyMap, Promise paramPromise, Context paramContext)
  {
    int i2 = paramHippyMap.getInt("limitNum");
    if (i2 < 1)
    {
      paramPromise.reject(VasHippyUtils.a(-1, "maxNum shoude more than 1", null));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramPromise = paramHippyMap.getMap("from_group");
    int i = 0;
    int k;
    int m;
    int n;
    int j;
    if ((paramPromise != null) && (paramPromise.size() > 0))
    {
      paramPromise = paramHippyMap.getString("group_uin");
      k = paramHippyMap.getInt("group_type");
      m = paramHippyMap.getInt("enable_select_all");
      n = paramHippyMap.getInt("enable_show_myself");
      int i1 = paramHippyMap.getInt("enable_show_myself_first");
      j = paramHippyMap.getInt("forbid_only_choose_myself");
      paramHippyMap = paramHippyMap.getArray("group_members");
      if ((paramHippyMap != null) && (paramHippyMap.size() > 0)) {
        while (i < paramHippyMap.size())
        {
          String str = paramHippyMap.getString(i);
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
          i += 1;
        }
      }
      paramHippyMap = paramPromise;
      i = i1;
    }
    else
    {
      paramHippyMap = null;
      k = 0;
      m = 0;
      n = 1;
      i = 0;
      j = 0;
    }
    paramPromise = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(paramContext);
    a(i2, paramHippyMap, k, localArrayList, m, n, i, j, paramPromise);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramPromise, 49);
  }
  
  private void a(Promise paramPromise, Context paramContext, HippyMap paramHippyMap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFriendInfoHippyHelper$ChooseFriendReceiver;
    if (localObject == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFriendInfoHippyHelper$ChooseFriendReceiver = new VasFriendInfoHippyHelper.ChooseFriendReceiver(paramPromise, new Handler());
    } else {
      ((VasFriendInfoHippyHelper.ChooseFriendReceiver)localObject).a(paramPromise);
    }
    Parcel localParcel = Parcel.obtain();
    paramPromise = this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFriendInfoHippyHelper$ChooseFriendReceiver;
    boolean bool4 = false;
    paramPromise.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    localParcel.recycle();
    localObject = paramHippyMap.getString("title");
    paramPromise = (Promise)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramPromise = HardCodeUtil.a(2131715789);
    }
    localObject = paramHippyMap.getString("dialog_sub_title");
    String str = paramHippyMap.getString("dialog_input");
    int i = paramHippyMap.getInt("type");
    boolean bool1;
    if ((i & 0x1) == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if ((i & 0x2) == 0) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool3;
    if ((i & 0xC) == 0) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    if ((i & 0x20) != 0) {
      bool4 = true;
    }
    i = paramHippyMap.getInt("business_type");
    int j = paramHippyMap.getInt("business_sub_type");
    paramHippyMap = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    paramContext = new Intent(paramContext, ForwardRecentActivity.class);
    paramContext.putExtra("forward_type", 15);
    paramContext.putExtra("choose_friend_title", paramPromise);
    paramContext.putExtra("choose_friend_dialog_sub_title", (String)localObject);
    paramContext.putExtra("choose_friend_dialog_input", str);
    paramContext.putExtra("choose_friend_is_qqfriends", bool1);
    paramContext.putExtra("choose_friend_is_contacts", bool2);
    paramContext.putExtra("choose_friend_is_groupchats", bool3);
    paramContext.putExtra("choose_friend_is_create_group_chat", bool4);
    paramContext.putExtra("choose_friend_callback", paramHippyMap);
    paramContext.putExtra("choose_friend_businessType", i);
    paramContext.putExtra("choose_friend_businessSubType", j);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramContext, 50);
  }
  
  public void a(Intent paramIntent, Promise paramPromise)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      Object localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
      if ((localObject3 != null) && (((ArrayList)localObject3).size() != 0))
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        Object localObject1 = paramIntent.getStringExtra("group_uin");
        Object localObject2 = paramIntent.getStringExtra("group_name");
        int i = paramIntent.getIntExtra("group_type", 0);
        int j = paramIntent.getIntExtra("group_member_type", 0);
        if (localObject1 != null)
        {
          localArrayList1.add(localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localArrayList2.add(localObject1);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(Integer.valueOf(j));
        }
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        ArrayList localArrayList5 = new ArrayList();
        ArrayList localArrayList6 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
          ((List)localObject1).add(localResultRecord.uin);
          ((List)localObject2).add("");
          localArrayList5.add(localResultRecord.name);
          localArrayList6.add(Integer.valueOf(i));
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasFriendInfoHippyHelper", 2, "doChooseFriendResult...");
        }
        paramIntent = a(paramIntent, (List)localObject1, (List)localObject2, localArrayList5, localArrayList6, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doChooseFriendResult: ");
        ((StringBuilder)localObject1).append(paramIntent);
        QLog.i("VasFriendInfoHippyHelper", 2, ((StringBuilder)localObject1).toString());
        if (paramIntent != null) {
          paramPromise.resolve(VasHippyUtils.a(0, "success", paramIntent));
        }
      }
      else
      {
        paramPromise.reject(VasHippyUtils.a(-1, "friendsList is empty", null));
        if (QLog.isColorLevel()) {
          QLog.i("VasFriendInfoHippyHelper", 2, "friendsList is empty");
        }
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramPromise.reject(VasHippyUtils.a(-1, paramIntent.toString(), null));
    }
  }
  
  public void a(HippyMap paramHippyMap, Promise paramPromise)
  {
    Context localContext = a();
    if ((localContext != null) && (paramHippyMap != null) && (paramHippyMap.size() > 0))
    {
      if (paramHippyMap.getBoolean("isMulti"))
      {
        a(paramHippyMap, paramPromise, localContext);
        return;
      }
      a(paramPromise, localContext, paramHippyMap);
      return;
    }
    paramPromise.reject(VasHippyUtils.a(-1, "params is empty", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFriendInfoHippyHelper
 * JD-Core Version:    0.7.0.1
 */