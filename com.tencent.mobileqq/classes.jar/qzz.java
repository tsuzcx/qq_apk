import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class qzz
{
  public static float a()
  {
    float f = ((Float)bgmq.a("readinjoy_font_size_sp", Float.valueOf(-1.0F))).floatValue();
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
    } while ((((ProteusItemData)localObject).t != 1) || (((ProteusItemData)localObject).f));
    if (((ProteusItemData)localObject).b != null) {}
    for (paramList = ((ProteusItemData)localObject).b.toString();; paramList = "data error!!")
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
            if ((((ProteusItemData)localObject).t == 1) && (((ProteusItemData)localObject).s == 1)) {
              ((ProteusItemData)localObject).b.put("attribute_text_size", String.valueOf(paramFloat));
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public static void a(List<BaseData> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    BaseData localBaseData;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localBaseData = (BaseData)paramList.next();
    } while (!(localBaseData instanceof ProteusAnimationItemData));
    ((ProteusAnimationItemData)localBaseData).a(paramBoolean);
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData.p == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).t == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBaseData.p == 18) || (paramBaseData.p == 22) || (paramBaseData.p == 0)) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzz
 * JD-Core Version:    0.7.0.1
 */