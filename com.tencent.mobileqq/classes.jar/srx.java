import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class srx
{
  public static float a()
  {
    return 16.0F;
  }
  
  public static String a()
  {
    return String.valueOf(((Float)bnrf.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue());
  }
  
  public static void a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData)) {
      a(((ProteusItemData)paramBaseData).c);
    }
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
    } while ((((ProteusItemData)localObject).v != 1) || (((ProteusItemData)localObject).e));
    if (((ProteusItemData)localObject).c != null) {}
    for (paramList = ((ProteusItemData)localObject).c.toString();; paramList = "data error!!")
    {
      a(paramList);
      return;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject.put("attribute_text_size_ratio", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSUtils", 1, "addTextSizeRatio error! msg=" + paramJSONObject);
    }
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData.r == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).v == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBaseData.r == 18) || (paramBaseData.r == 22) || (paramBaseData.r == 0)) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srx
 * JD-Core Version:    0.7.0.1
 */