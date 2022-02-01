package com.tencent.mobileqq.tofumsg.handlers;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;
import tencent.im.beancurd.anniversary.Anniversary;
import tencent.im.beancurd.anniversary.AnniversaryInfo;

public class IntimateAnniversaryDataHandler
  extends TofuDataBaseHandler
{
  public IntimateAnniversaryDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 8;
  }
  
  public byte[] b(TofuItem paramTofuItem)
  {
    return null;
  }
  
  public String c(TofuItem paramTofuItem)
  {
    if ((paramTofuItem.bytesFromServer != null) && (paramTofuItem.bytesFromServer.length > 0)) {}
    for (;;)
    {
      try
      {
        localObject1 = new anniversary.Anniversary();
        ((anniversary.Anniversary)localObject1).mergeFrom(paramTofuItem.bytesFromServer);
        if ((((anniversary.Anniversary)localObject1).rpt_anniversary_info.has()) && (((anniversary.Anniversary)localObject1).rpt_anniversary_info.get() != null) && (((anniversary.Anniversary)localObject1).rpt_anniversary_info.get().size() > 0))
        {
          localObject2 = (anniversary.AnniversaryInfo)((anniversary.Anniversary)localObject1).rpt_anniversary_info.get(0);
          if (!((anniversary.AnniversaryInfo)localObject2).uint64_type.has()) {
            break label632;
          }
          i = (int)((anniversary.AnniversaryInfo)localObject2).uint64_type.get();
          if (((anniversary.AnniversaryInfo)localObject2).uint64_frd_uin.has()) {
            ((anniversary.AnniversaryInfo)localObject2).uint64_frd_uin.get();
          }
          if (!((anniversary.AnniversaryInfo)localObject2).uint64_bind_time.has()) {
            break label637;
          }
          l = ((anniversary.AnniversaryInfo)localObject2).uint64_bind_time.get();
          if (!((anniversary.AnniversaryInfo)localObject2).uint64_n.has()) {
            break label643;
          }
          j = (int)((anniversary.AnniversaryInfo)localObject2).uint64_n.get();
          if (!((anniversary.AnniversaryInfo)localObject2).uint64_level.has()) {
            break label648;
          }
          k = (int)((anniversary.AnniversaryInfo)localObject2).uint64_level.get();
          if (!((anniversary.AnniversaryInfo)localObject2).str_bg_url.has()) {
            break label654;
          }
          localObject1 = ((anniversary.AnniversaryInfo)localObject2).str_bg_url.get();
          if (!((anniversary.AnniversaryInfo)localObject2).str_text_color.has()) {
            break label661;
          }
          localObject2 = ((anniversary.AnniversaryInfo)localObject2).str_text_color.get();
          if ((i < 0) || (l <= 0L) || (j <= 0) || (k < 0) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label668;
          }
          m = 1;
          if (m != 0)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("key_frd_uin", paramTofuItem.frdUin);
            localJSONObject.put("key_type", i);
            localJSONObject.put("key_bind_time", l);
            localJSONObject.put("key_anniversary_years", j);
            localJSONObject.put("key_inimate_level", k);
            localJSONObject.put("key_bg_url", localObject1);
            localJSONObject.put("key_txt_clr", localObject2);
            paramTofuItem = localJSONObject.toString();
            break label674;
          }
          if (localObject1 == null) {
            m = -1;
          } else {
            m = ((String)localObject1).length();
          }
          QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, String.format("getBusDataFromRspBytes not valid. type=%d bindTime=%d years=%d level=%d bgUrl.size=%d txtColor=%s", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), localObject2 }));
          paramTofuItem = null;
          break label674;
        }
        if (!((anniversary.Anniversary)localObject1).rpt_anniversary_info.has()) {
          break label677;
        }
        i = ((anniversary.Anniversary)localObject1).rpt_anniversary_info.size();
        QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, String.format("getBusDataFromRspBytes no data. infos.size=%d", new Object[] { Integer.valueOf(i) }));
        paramTofuItem = null;
      }
      catch (Exception paramTofuItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBusDataFromRspBytes exception=");
        ((StringBuilder)localObject1).append(paramTofuItem.getMessage());
        QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, ((StringBuilder)localObject1).toString(), paramTofuItem);
        paramTofuItem = null;
      }
      break label605;
      if (paramTofuItem.bytesFromServer == null) {
        i = -1;
      } else {
        i = paramTofuItem.bytesFromServer.length;
      }
      QLog.d("Tofu_IntimateAnniversaryDataHandler", 1, new Object[] { "getBusDataFromRspBytes bytesFromServer size=", Integer.valueOf(i) });
      paramTofuItem = null;
      label605:
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_IntimateAnniversaryDataHandler", 2, String.format("getBusDataFromRspBytes %s", new Object[] { paramTofuItem }));
      }
      return paramTofuItem;
      label632:
      int i = -1;
      continue;
      label637:
      long l = 0L;
      continue;
      label643:
      int j = 0;
      continue;
      label648:
      int k = 0;
      continue;
      label654:
      Object localObject1 = "";
      continue;
      label661:
      Object localObject2 = "#000";
      continue;
      label668:
      int m = 0;
      continue;
      label674:
      continue;
      label677:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.IntimateAnniversaryDataHandler
 * JD-Core Version:    0.7.0.1
 */