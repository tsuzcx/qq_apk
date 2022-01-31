package com.tencent.mobileqq.troop.homework.recite.data;

import android.os.Bundle;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.util.JSONUtils.FieldName;
import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.mobileqq.util.TroopReportor;
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
  @JSONUtils.FieldName(a="author")
  public String author;
  @JSONUtils.FieldName(a="grade")
  public int grade;
  @JSONUtils.FieldName(a="kid")
  public String kid;
  @JSONUtils.FieldName(a="level")
  public int level;
  @JSONUtils.FieldName(a="paragraphs")
  @JSONUtils.GenericType(a=ParagraphInfo.class)
  public List paragraphs;
  @JSONUtils.FieldName(a="title")
  public String title;
  @JSONUtils.FieldName(a="type")
  public int type;
  @JSONUtils.FieldName(a="version")
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
      int i;
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
          break label331;
        }
        localObject1 = ((JSONObject)localObject3).getJSONArray("rs");
        if (((JSONArray)localObject1).length() <= 0) {
          break label326;
        }
        localObject1 = (ArticleInfo)JSONUtils.b(((JSONArray)localObject1).getJSONObject(0), ArticleInfo.class);
        localObject3 = "0";
        i = 1;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      catch (JSONException localJSONException)
      {
        Object localObject3 = "-1";
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(a, 2, localJSONException, new Object[0]);
        localObject1 = localObject3;
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
            TroopReportor.a("Grp_edu", "publish_homework", "get_kewen_info", 0, i, new String[] { localObject2, paramBundle, localObject1 });
          }
        }
        else
        {
          return paramJSONObject;
          localObject1 = String.valueOf(i);
          i = 0;
          continue;
          localObject1 = String.valueOf(i);
          i = 0;
          continue;
          if ((QLog.isColorLevel()) && (paramBundle != null)) {
            QLog.e(a, 2, new Object[] { "onHandleGetArticleDetail client error: ", paramBundle });
          }
          paramJSONObject = null;
          localObject1 = "-1";
          i = 0;
          continue;
        }
        i = 2;
      }
      else
      {
        paramJSONObject = (JSONObject)localObject2;
        continue;
        label326:
        localObject1 = null;
        continue;
        label331:
        localObject1 = "0";
        i = 1;
      }
    }
  }
  
  public String toString()
  {
    return "ArticleInfo{title='" + this.title + '\'' + ", author=" + this.author + ", level=" + this.level + ", paragraphs=" + this.paragraphs + ", grade=" + this.grade + ", version='" + this.version + '\'' + ", kid='" + this.kid + '\'' + ", type='" + this.type + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */