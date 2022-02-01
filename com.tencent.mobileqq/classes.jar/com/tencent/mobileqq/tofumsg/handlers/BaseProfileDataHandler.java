package com.tencent.mobileqq.tofumsg.handlers;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfileInfo;>;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.EduHis;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.SchoolInfo;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfile;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.BeancurdcubeProfileInfo;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileBirthday;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileCompany;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileEducation;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileEmail;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileHomeLand;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileIntro;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileLocation;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileNickname;
import tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileOccupation;
import tencent.im.oidb.cmd0xe6b.oidb_0xe6b.ReqBody;
import tencent.im.oidb.cmd0xe6b.oidb_0xe6b.RspBody;

public class BaseProfileDataHandler
  extends TofuDataBaseHandler
  implements ConditionSearchManager.IConfigListener
{
  ConditionSearchManager b;
  WeakReference<BaseProfileDataHandler> c = new WeakReference(this);
  volatile boolean d;
  final Object e = new Object();
  
  public BaseProfileDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = ((ConditionSearchManager)paramQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    this.b.a(this.c);
    this.b.c(this);
  }
  
  private String a(StringBuilder paramStringBuilder, List<beancurdcube_profile_common.BeancurdcubeProfileInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    Object localObject2;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      StringBuilder localStringBuilder = null;
      Object localObject1 = null;
      localObject2 = null;
      paramList = null;
      if (!bool) {
        break;
      }
      beancurdcube_profile_common.BeancurdcubeProfileInfo localBeancurdcubeProfileInfo = (beancurdcube_profile_common.BeancurdcubeProfileInfo)localIterator.next();
      int k = localBeancurdcubeProfileInfo.enum_beancurdcube_profile_type.get();
      JSONObject localJSONObject = new JSONObject();
      long l = localBeancurdcubeProfileInfo.uint32_last_modify_time.get();
      paramStringBuilder.append("|");
      paramStringBuilder.append(k);
      localObject2 = "";
      if (k != 20002)
      {
        if (k != 20011)
        {
          if (k != 20019)
          {
            if (k != 24002)
            {
              if (k != 24008)
              {
                if (k != 27037)
                {
                  if (k != 27264)
                  {
                    if (k != 20031)
                    {
                      if (k == 20032)
                      {
                        paramList = (beancurdcube_profile_common.ProfileLocation)localBeancurdcubeProfileInfo.msg_location.get();
                        if (a(localJSONObject, paramList.uint32_nation.get(), paramList.uint32_province.get(), paramList.uint32_city.get(), paramList.uint32_district.get())) {}
                      }
                    }
                    else {
                      localJSONObject.put("key_profile_birthday", ((beancurdcube_profile_common.ProfileBirthday)localBeancurdcubeProfileInfo.msg_birthday.get()).uint32_birthday.get());
                    }
                  }
                  else
                  {
                    paramList = (beancurdcube_profile_common.ProfileEducation)localBeancurdcubeProfileInfo.msg_education.get();
                    if (paramList.msg_edu.has()) {
                      paramList = (oidb_cmd0xd2d_common.EduHis)paramList.msg_edu.get();
                    } else {
                      paramList = null;
                    }
                    if (paramList == null) {
                      continue;
                    }
                    if (paramList.rpt_msg_school.has()) {
                      paramList = paramList.rpt_msg_school.get();
                    } else {
                      paramList = null;
                    }
                    if ((paramList == null) || (paramList.size() == 0)) {
                      continue;
                    }
                    localStringBuilder = new StringBuilder();
                    localObject2 = paramList.iterator();
                    int j = 0;
                    while (((Iterator)localObject2).hasNext())
                    {
                      paramList = (oidb_cmd0xd2d_common.SchoolInfo)((Iterator)localObject2).next();
                      if (paramList.str_school_name.has()) {
                        paramList = paramList.str_school_name.get();
                      } else {
                        paramList = null;
                      }
                      if ((!TextUtils.isEmpty(paramList)) && (j < 3))
                      {
                        if (j > 0) {
                          localObject1 = "、";
                        } else {
                          localObject1 = "";
                        }
                        localStringBuilder.append((String)localObject1);
                        localStringBuilder.append(paramList);
                        j += 1;
                      }
                    }
                    if (localStringBuilder.length() <= 0) {
                      continue;
                    }
                    localJSONObject.put("key_profile_education", localStringBuilder.toString());
                  }
                }
                else {
                  localJSONObject.put("key_profile_occupation", ((beancurdcube_profile_common.ProfileOccupation)localBeancurdcubeProfileInfo.msg_occupation.get()).uint32_occupation_id.get());
                }
              }
              else
              {
                localObject1 = (beancurdcube_profile_common.ProfileCompany)localBeancurdcubeProfileInfo.msg_company.get();
                if (((beancurdcube_profile_common.ProfileCompany)localObject1).company_name.has()) {
                  paramList = ((beancurdcube_profile_common.ProfileCompany)localObject1).company_name.get().toStringUtf8();
                }
                if (TextUtils.isEmpty(paramList)) {
                  continue;
                }
                localJSONObject.put("key_profile_company", paramList);
              }
            }
            else
            {
              paramList = (beancurdcube_profile_common.ProfileHomeLand)localBeancurdcubeProfileInfo.msg_homeland.get();
              if (a(localJSONObject, paramList.uint32_nation.get(), paramList.uint32_province.get(), paramList.uint32_city.get(), paramList.uint32_district.get())) {}
            }
          }
          else
          {
            localObject1 = (beancurdcube_profile_common.ProfileIntro)localBeancurdcubeProfileInfo.msg_intro.get();
            paramList = localStringBuilder;
            if (((beancurdcube_profile_common.ProfileIntro)localObject1).bytes_intro.has()) {
              paramList = ((beancurdcube_profile_common.ProfileIntro)localObject1).bytes_intro.get().toStringUtf8();
            }
            if (TextUtils.isEmpty(paramList)) {
              continue;
            }
            localJSONObject.put("key_profile_introduction", paramList);
          }
        }
        else
        {
          if (localBeancurdcubeProfileInfo.msg_email.has()) {
            paramList = (beancurdcube_profile_common.ProfileEmail)localBeancurdcubeProfileInfo.msg_email.get();
          } else {
            paramList = null;
          }
          if (paramList.bytes_email.has()) {
            localObject1 = paramList.bytes_email.get().toStringUtf8();
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          localJSONObject.put("key_profile_email", localObject1);
        }
      }
      else
      {
        localObject1 = (beancurdcube_profile_common.ProfileNickname)localBeancurdcubeProfileInfo.msg_nickname.get();
        paramList = (List<beancurdcube_profile_common.BeancurdcubeProfileInfo>)localObject2;
        if (((beancurdcube_profile_common.ProfileNickname)localObject1).bytes_nickname.has()) {
          paramList = ((beancurdcube_profile_common.ProfileNickname)localObject1).bytes_nickname.get().toStringUtf8();
        }
        if (TextUtils.isEmpty(paramList)) {
          continue;
        }
        localJSONObject.put("key_profile_nickname", paramList);
      }
      i += 1;
      localJSONObject.put("key_ts", l);
      localJSONObject.put("key_type", k);
      localJSONArray.put(localJSONObject);
    }
    paramStringBuilder = (StringBuilder)localObject2;
    if (i > 0) {
      paramStringBuilder = localJSONArray.toString();
    }
    return paramStringBuilder;
  }
  
  private String a(oidb_0xe6b.RspBody paramRspBody, StringBuilder paramStringBuilder)
  {
    if (paramRspBody.msg_profile_info.has()) {
      paramRspBody = (beancurdcube_profile_common.BeancurdcubeProfile)paramRspBody.msg_profile_info.get();
    } else {
      paramRspBody = null;
    }
    if (paramRspBody != null)
    {
      List localList;
      if (paramRspBody.rpt_beancurdcube_profile_info.has()) {
        localList = paramRspBody.rpt_beancurdcube_profile_info.get();
      } else {
        localList = null;
      }
      if ((localList != null) && (localList.size() > 0)) {
        return a(paramStringBuilder, localList);
      }
      int i;
      if (paramRspBody.rpt_beancurdcube_profile_info.has()) {
        i = paramRspBody.rpt_beancurdcube_profile_info.get().size();
      } else {
        i = -1;
      }
      QLog.d("Tofu_BaseProfileDataHandler", 1, String.format("getBusDataFromRspBytes rpt_beancurdcube_profile_info.size=%d", new Object[] { Integer.valueOf(i) }));
      return null;
    }
    QLog.d("Tofu_BaseProfileDataHandler", 1, "getBusDataFromRspBytes beancurdcubeProfile is null");
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ConditionSearchManager.a(paramInt1);
    arrayOfString[1] = ConditionSearchManager.a(paramInt2);
    arrayOfString[2] = ConditionSearchManager.a(paramInt3);
    arrayOfString[3] = ConditionSearchManager.a(paramInt4);
    if (!this.d) {
      synchronized (this.e)
      {
        boolean bool = this.d;
        if (bool) {}
      }
    }
    try
    {
      this.e.wait(1000L);
      label81:
      break label93;
      paramJSONObject = finally;
      throw paramJSONObject;
      label93:
      if (!this.d)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Tofu_BaseProfileDataHandler", 2, "parseLocation location not ready return");
        }
        return false;
      }
      String str = this.b.d(arrayOfString);
      ??? = str;
      if (str.equals("不限")) {
        ??? = "";
      }
      paramJSONObject.put("key_profile_location_desc", ???);
      paramJSONObject.put("key_profile_location_1", arrayOfString[0]);
      paramJSONObject.put("key_profile_location_2", arrayOfString[1]);
      paramJSONObject.put("key_profile_location_3", arrayOfString[2]);
      paramJSONObject.put("key_profile_location_4", arrayOfString[3]);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label81;
    }
  }
  
  public int a()
  {
    return 9;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean)) {
      synchronized (this.e)
      {
        this.d = true;
        this.e.notifyAll();
        if (QLog.isColorLevel())
        {
          QLog.i("Tofu_BaseProfileDataHandler", 2, "onGetConfig location parse ready");
          return;
        }
      }
    }
  }
  
  public void b()
  {
    this.b.d(this);
    this.b.b(this.c);
  }
  
  public byte[] b(TofuItem paramTofuItem)
  {
    oidb_0xe6b.ReqBody localReqBody = new oidb_0xe6b.ReqBody();
    localReqBody.uint64_frd_uin.set(paramTofuItem.frdUin);
    localReqBody.uint32_last_query_time.set((int)paramTofuItem.lastPullTsSvr);
    return localReqBody.toByteArray();
  }
  
  public String c(TofuItem paramTofuItem)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    String str;
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0))
    {
      Object localObject = new oidb_0xe6b.RspBody();
      try
      {
        ((oidb_0xe6b.RspBody)localObject).mergeFrom(paramTofuItem.bytesFromServer);
        localObject = a((oidb_0xe6b.RspBody)localObject, localStringBuilder1);
      }
      catch (Exception localException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getBusDataFromRspBytes Exception=");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("Tofu_BaseProfileDataHandler", 1, localStringBuilder2.toString(), localException);
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getBusDataFromRspBytes JSONException=");
        localStringBuilder2.append(localJSONException.getMessage());
        QLog.d("Tofu_BaseProfileDataHandler", 1, localStringBuilder2.toString(), localJSONException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getBusDataFromRspBytes InvalidProtocolBufferMicroException=");
        localStringBuilder2.append(localInvalidProtocolBufferMicroException.getMessage());
        QLog.d("Tofu_BaseProfileDataHandler", 1, localStringBuilder2.toString(), localInvalidProtocolBufferMicroException);
      }
    }
    else
    {
      str = null;
    }
    if (QLog.isColorLevel())
    {
      int i;
      if (paramTofuItem.bytesFromServer == null) {
        i = -1;
      } else {
        i = paramTofuItem.bytesFromServer.length;
      }
      QLog.i("Tofu_BaseProfileDataHandler", 2, String.format("getBusDataFromRspBytes [%s] size=%d types=%s", new Object[] { str, Integer.valueOf(i), localStringBuilder1.toString() }));
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.BaseProfileDataHandler
 * JD-Core Version:    0.7.0.1
 */