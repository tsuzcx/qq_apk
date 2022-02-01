import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class sru
{
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, FastWebActivity paramFastWebActivity, JSONObject paramJSONObject, List<BaseData> paramList, ArrayList<String> paramArrayList)
  {
    if ((paramFastWebActivity == null) || (paramJSONObject == null)) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("articleImageUrl");
      if (paramArrayList.isEmpty())
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (BaseData)paramList.next();
          boolean bool = localObject instanceof ProteusItemData;
          if (bool) {
            try
            {
              localObject = (ProteusItemData)localObject;
              if (((ProteusItemData)localObject).u == 2) {
                paramArrayList.add(ozs.f(((ProteusItemData)localObject).c.getString("articleImageUrl")));
              }
            }
            catch (Exception localException)
            {
              QLog.d("FastWebImageItemUtils", 1, "handlerImageClick error!!! msg=" + localException);
            }
          }
        }
      }
      bghf.a(paramFastWebActivity, paramArrayList.indexOf(ozs.f(paramJSONObject)), paramArrayList, null, null, false, true, "4", 1000, null, null, null, null, "", true);
    }
    catch (Exception paramArticleInfo)
    {
      QLog.d("FastWebImageItemUtils", 1, "handlerImageClick error! msg=" + paramArticleInfo);
      return;
    }
    if (paramFastWebArticleInfo.c()) {}
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      ssy.a(paramArticleInfo, "0X8008996", ozs.a(paramFastWebActivity, paramArticleInfo, 0, paramFastWebArticleInfo).toString());
      return;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    int j;
    for (;;)
    {
      try
      {
        i = FastWebActivity.a(BaseApplicationImpl.getContext());
        j = Integer.valueOf(paramString1).intValue();
        k = Integer.valueOf(paramString2).intValue();
        if (a(j)) {
          i = Utils.dp2px(j);
        }
      }
      catch (Exception paramJSONObject)
      {
        int k;
        int m;
        int i = 0;
        j = 0;
        QLog.d("FastWebImageItemUtils", 1, "insertDynamicData error! msg=" + paramJSONObject);
        continue;
      }
      try
      {
        j = i * k / j;
        if ((j <= 0) || (i <= 0)) {}
      }
      catch (Exception paramJSONObject)
      {
        j = 0;
        continue;
      }
      try
      {
        paramJSONObject.put("style_ID", "ReadInjoy_article_image_cell");
        paramJSONObject.put("imageHeight", j);
        paramJSONObject.put("imageWidth", i);
        paramJSONObject.put("articleImageUrl", paramString3);
        paramJSONObject.put("lineup", "0");
        QLog.d("FastWebImageItemUtils", 1, "insertDynamicData image w,h error! w=" + i + "  h=" + j);
        if ((!TextUtils.isEmpty(paramString3)) && (j > 0) && (i > 0)) {
          break label227;
        }
        return false;
      }
      catch (Exception paramJSONObject)
      {
        continue;
      }
      m = Utils.dp2px(15.0D);
      i -= m * 2;
    }
    label227:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sru
 * JD-Core Version:    0.7.0.1
 */