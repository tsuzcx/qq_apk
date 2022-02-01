package com.tencent.mobileqq.tribe.fragment;

import android.net.Uri;
import betw;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TribeVideoListPlayerFragment$6
  implements Runnable
{
  TribeVideoListPlayerFragment$6(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, boolean paramBoolean, betw parambetw, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    long l;
    label48:
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Boolean)
    {
      l = this.jdField_a_of_type_Betw.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Betw.b != 0) || (this.b != 0L) || (l <= 0L)) {
        break label265;
      }
      this.jdField_a_of_type_Betw.b = 1;
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("bt", "" + this.b);
        localJSONObject.put("et", "" + l);
        if (this.b != 0L) {
          continue;
        }
        str = "1";
        localJSONObject.put("bf", str);
        if (l < this.jdField_a_of_type_Betw.jdField_a_of_type_Long - 100L) {
          continue;
        }
        str = "1";
        localJSONObject.put("ef", str);
        localJSONObject.put("pp", "3");
        localJSONObject.put("pa", "" + this.jdField_a_of_type_Betw.b);
        str = this.jdField_a_of_type_Betw.i + "&video=" + Uri.encode(localJSONObject.toString());
        HttpUtil.openRequest(BaseApplicationImpl.getContext(), str, null, "GET", null, null);
        return;
      }
      catch (Exception localException)
      {
        String str;
        label265:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TribeVideoListPlayerFragment", 2, "reportAdVideoTime: " + QLog.getStackTraceString(localException));
      }
      l = this.jdField_a_of_type_Long;
      break;
      if ((this.jdField_a_of_type_Betw.b != 0) && (this.b > 0L) && (l > 0L))
      {
        this.jdField_a_of_type_Betw.b = 2;
        break label48;
      }
      if ((this.jdField_a_of_type_Betw.b != 0) && (this.b == 0L) && (l > 0L))
      {
        this.jdField_a_of_type_Betw.b = 3;
        break label48;
      }
      this.jdField_a_of_type_Betw.b = 4;
      break label48;
      str = "0";
      continue;
      str = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.6
 * JD-Core Version:    0.7.0.1
 */