package com.tencent.mobileqq.troop.homework.recite.data;

import android.os.Bundle;
import android.text.TextUtils;
import bgzr;
import bgzs;
import bgzt;
import bhbu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArticleInfo
  implements Serializable
{
  public static final int TYPE_CI = 3;
  public static final int TYPE_GUSHI = 2;
  public static final int TYPE_SANWEN = 1;
  private static final String a = ArticleInfo.class.getSimpleName();
  @bgzs(a="author")
  public String author;
  @bgzs(a="grade")
  public int grade;
  @bgzs(a="kid")
  public String kid;
  @bgzs(a="level")
  public int level;
  @bgzs(a="paragraphs")
  @bgzt(a=ParagraphInfo.class)
  public List<ParagraphInfo> paragraphs;
  @bgzs(a="title")
  public String title;
  @bgzs(a="type")
  public int type;
  @bgzs(a="version")
  public String version;
  
  public static ArticleInfo onHandleGetArticleDetail(Bundle paramBundle, JSONObject paramJSONObject)
  {
    Object localObject1 = "0";
    Object localObject2 = null;
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, paramJSONObject.toString());
      }
    }
    for (;;)
    {
      try
      {
        i = paramJSONObject.getInt("retcode");
        if (i != 0) {
          continue;
        }
        localObject3 = paramJSONObject.getJSONObject("result");
        if (localObject3 == null) {
          continue;
        }
        i = ((JSONObject)localObject3).getInt("errCode");
        if (i != 0) {
          continue;
        }
        if (!((JSONObject)localObject3).has("rs")) {
          break label402;
        }
        localObject1 = ((JSONObject)localObject3).getJSONArray("rs");
        if (((JSONArray)localObject1).length() <= 0) {
          break label397;
        }
        localObject1 = (ArticleInfo)bgzr.b(((JSONArray)localObject1).getJSONObject(0), ArticleInfo.class);
        str = "0";
        i = 1;
        localObject2 = localObject1;
        localObject1 = str;
      }
      catch (JSONException localJSONException)
      {
        Object localObject3;
        String str = "-1";
        localObject1 = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(a, 2, localJSONException, new Object[0]);
        localObject1 = str;
        i = 0;
        continue;
      }
      if ((i == 0) && (paramBundle != null) && (QLog.isColorLevel()))
      {
        QLog.e(a, 2, new Object[] { "onHandleGetArticleDetail server error: ", paramBundle, "\n", paramJSONObject });
        paramJSONObject = (JSONObject)localObject2;
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("kid", "");
          paramBundle = paramBundle.getString("pid_list", "");
          if (i != 0)
          {
            i = 1;
            bhbu.a("Grp_edu", "publish_homework", "get_kewen_info", 0, i, new String[] { localObject2, paramBundle, localObject1 });
          }
        }
        else
        {
          return paramJSONObject;
          str = String.valueOf(i);
          localObject3 = ((JSONObject)localObject3).optString("errMsg");
          localObject1 = str;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label410;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, (CharSequence)localObject3, 1).a();
          localObject1 = str;
          break label410;
          str = String.valueOf(i);
          localObject3 = paramJSONObject.optString("msg");
          localObject1 = str;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label410;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, (CharSequence)localObject3, 1).a();
          localObject1 = str;
          break label410;
          if ((QLog.isColorLevel()) && (paramBundle != null)) {
            QLog.e(a, 2, new Object[] { "onHandleGetArticleDetail client error: ", paramBundle });
          }
          paramJSONObject = null;
          localObject1 = "-1";
          i = 0;
          continue;
        }
        i = 2;
        continue;
      }
      else
      {
        paramJSONObject = (JSONObject)localObject2;
        continue;
        label397:
        localObject1 = null;
        continue;
        label402:
        localObject1 = "0";
        i = 1;
        continue;
      }
      label410:
      int i = 0;
    }
  }
  
  public String toString()
  {
    return "ArticleInfo{title='" + this.title + '\'' + ", author=" + this.author + ", level=" + this.level + ", paragraphs=" + this.paragraphs + ", grade=" + this.grade + ", version='" + this.version + '\'' + ", kid='" + this.kid + '\'' + ", type='" + this.type + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */