import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class scm
{
  public static float a()
  {
    float f = ((Float)bkbq.a("readinjoy_font_size_sp", Float.valueOf(-1.0F))).floatValue();
    if (f == -1.0F) {
      return 16.0F;
    }
    return Utils.px2dp(f);
  }
  
  private static void a(String paramString)
  {
    QLog.e("FastWebPTSUtils", 1, "errorUrl!! detail:" + paramString);
    throw new IllegalArgumentException(paramString);
  }
  
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        while (!paramList.hasNext()) {
          paramList = paramList.iterator();
        }
        localObject = (BaseData)paramList.next();
      } while (!(localObject instanceof ProteusItemData));
      localObject = (ProteusItemData)localObject;
    } while ((((ProteusItemData)localObject).w != 1) || (((ProteusItemData)localObject).f));
    if (((ProteusItemData)localObject).c != null) {}
    for (paramList = ((ProteusItemData)localObject).c.toString();; paramList = "data error!!")
    {
      a(paramList);
      return;
    }
  }
  
  public static void a(List<BaseData> paramList, float paramFloat)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramFloat = Utils.px2dp(paramFloat);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        try
        {
          if ((localObject instanceof ProteusItemData))
          {
            localObject = (ProteusItemData)localObject;
            if ((((ProteusItemData)localObject).w == 1) && (((ProteusItemData)localObject).v == 1)) {
              ((ProteusItemData)localObject).c.put("attribute_text_size", String.valueOf(paramFloat));
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData.s == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).w == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBaseData.s == 18) || (paramBaseData.s == 22) || (paramBaseData.s == 0)) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     scm
 * JD-Core Version:    0.7.0.1
 */