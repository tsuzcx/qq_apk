import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.gson.JsonArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;

public class qnj
  implements qqa
{
  private static final Set<Integer> a = new HashSet(Collections.singletonList(Integer.valueOf(4)));
  private static final Set<Integer> b = new HashSet(Collections.singletonList(Integer.valueOf(1)));
  private static final Set<Integer> c = new HashSet(Collections.singletonList(Integer.valueOf(6)));
  private static final Set<Integer> d = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  private static final Set<Integer> e = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7) }));
  private static final Set<Integer> f = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> g = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> h = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
  
  @VisibleForTesting
  static String a(long paramLong1, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    if ((l <= 0L) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = pkh.a(2131717918);
      if (l >= 60000L) {
        break;
      }
      localObject = str;
    } while (!str.isEmpty());
    Object localObject = pkh.a(2131717919);
    if ((l < 3600000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L) });
    }
    localObject = pkh.a(2131717917);
    if ((l < 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L) });
    }
    localObject = pkh.a(2131717916);
    if ((l >= 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L / 24L) });
    }
    return "";
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo)
  {
    rpr localrpr = paramArticleInfo.multiVideoColumnInfo;
    HashMap localHashMap = new HashMap();
    localHashMap.put("feeds_type", Integer.valueOf(1050));
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = localrpr.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((rrv)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("rowkey", localJsonArray);
    localHashMap.put("column_id", Integer.valueOf(localrpr.jdField_a_of_type_Int));
    localHashMap.put("column_card_bg_style", Integer.valueOf(localrpr.e));
    if (localrpr.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("subscribe_flag", Integer.valueOf(i));
      pqb.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
      return;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    QLog.d("ColumnTwoVideoProteusItem", 1, "requestSubscribeEvent, subscribeAction = " + paramInt);
    rpr localrpr = paramArticleInfo.multiVideoColumnInfo;
    oidb_0xd4b.ReqBody localReqBody = new oidb_0xd4b.ReqBody();
    localReqBody.msg_subscribe_video_column_req.uint32_video_column_id.set(localrpr.jdField_a_of_type_Int);
    localReqBody.msg_subscribe_video_column_req.uint32_oper_type.set(paramInt);
    localReqBody.msg_subscribe_video_column_req.setHasFlag(true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("subscribeAction", paramInt);
    localBundle.putString("columnIconUrl", localrpr.jdField_b_of_type_JavaLangString);
    localBundle.putInt("columnId", localrpr.jdField_a_of_type_Int);
    ntb.a(pnn.a(), new qno(paramArticleInfo, paramInt), localReqBody.toByteArray(), "OidbSvc.0xd4b", 3403, 1, localBundle);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    rpr localrpr = paramArticleInfo.multiVideoColumnInfo;
    String str;
    HashMap localHashMap;
    if (paramBoolean)
    {
      str = "0x800A7FB";
      localHashMap = new HashMap();
      if (paramArticleInfo.mChannelID != 0L) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 2)
    {
      localHashMap.put("subscribe_page", Integer.valueOf(i));
      localHashMap.put("feeds_type", Integer.valueOf(1050));
      localHashMap.put("column_id", Integer.valueOf(localrpr.jdField_a_of_type_Int));
      localHashMap.put("column_card_bg_style", Integer.valueOf(localrpr.e));
      pqb.a(paramArticleInfo, str, str, (int)paramArticleInfo.mChannelID, localHashMap);
      return;
      str = "0x800A7D3";
      break;
    }
  }
  
  private void a(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    String str = paramrpr.jdField_a_of_type_JavaLangString;
    if (str.isEmpty()) {
      QLog.e("ColumnTwoVideoProteusItem", 1, "column Name is empty.");
    }
    if ((a.contains(Integer.valueOf(paramrpr.e))) && (!paramrpr.g.isEmpty()))
    {
      paramJSONObject.put("column_info_name_text", paramrpr.g + "·" + str);
      return;
    }
    paramJSONObject.put("column_info_name_text", str);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull rpr paramrpr, rrv paramrrv1, rrv paramrrv2)
  {
    if (c.contains(Integer.valueOf(paramrpr.e)))
    {
      if (paramrrv1.jdField_b_of_type_JavaLangString.isEmpty()) {
        break label65;
      }
      paramJSONObject.put("column_show_video_left_title", paramrrv1.jdField_b_of_type_JavaLangString);
    }
    while (!paramrrv2.jdField_b_of_type_JavaLangString.isEmpty())
    {
      paramJSONObject.put("column_show_video_right_title", paramrrv2.jdField_b_of_type_JavaLangString);
      return;
      label65:
      QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's title isEmpty.");
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's title isEmpty.");
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramJSONObject.put("subscription_background_color", "#FFFFFF");
      paramJSONObject.put("subscribe_title", pkh.a(2131695027));
      paramJSONObject.put("subscription_title_color", "#737373");
      paramJSONObject.put("subscription_border_color", "#E6E6E6");
      paramJSONObject.put("subscription_border_width", "0.5");
      return;
    }
    paramJSONObject.put("subscription_background_color", "#00CAFC");
    paramJSONObject.put("subscribe_title", pkh.a(2131695028));
    paramJSONObject.put("subscription_title_color", "#FFFFFF");
    paramJSONObject.remove("subscription_border_color");
    paramJSONObject.remove("subscription_border_width");
  }
  
  private void a(rpr paramrpr, JSONObject paramJSONObject)
  {
    paramJSONObject.put("column_cover_image_url", paramrpr.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("column_logo_image_url", paramrpr.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramrpr);
    b(paramJSONObject, paramrpr);
    a(paramJSONObject, paramrpr.jdField_a_of_type_Boolean);
  }
  
  private void b(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    String str = pkh.a(2131717627);
    if ((b.contains(Integer.valueOf(paramrpr.e))) && (paramrpr.d != 0) && (!str.isEmpty())) {
      paramJSONObject.put("column_info_subscription_text", String.format(str, new Object[] { bmhv.b(paramrpr.d) }));
    }
  }
  
  private void b(JSONObject paramJSONObject, @NotNull rpr paramrpr, rrv paramrrv1, rrv paramrrv2)
  {
    if (e.contains(Integer.valueOf(paramrpr.e)))
    {
      if (paramrrv1.jdField_b_of_type_Int == 0) {
        break label65;
      }
      paramJSONObject.put("column_card_play_left_time_text", bmhv.c(paramrrv1.jdField_b_of_type_Int));
    }
    while (paramrrv2.jdField_b_of_type_Int != 0)
    {
      paramJSONObject.put("column_card_play_right_time_text", bmhv.c(paramrrv2.jdField_b_of_type_Int));
      return;
      label65:
      QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's duration == 0.");
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's duration == 0.");
  }
  
  private void b(rpr paramrpr, JSONObject paramJSONObject)
  {
    rrv localrrv1 = (rrv)paramrpr.jdField_a_of_type_JavaUtilList.get(0);
    rrv localrrv2 = (rrv)paramrpr.jdField_a_of_type_JavaUtilList.get(1);
    paramJSONObject.put("column_left_item_cover_url", localrrv1.jdField_c_of_type_JavaLangString);
    paramJSONObject.put("column_right_item_cover_url", localrrv2.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramrpr, localrrv1, localrrv2);
    c(paramJSONObject, paramrpr);
    b(paramJSONObject, paramrpr, localrrv1, localrrv2);
  }
  
  private void c(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    if (d.contains(Integer.valueOf(paramrpr.e)))
    {
      paramJSONObject.put("column_card_play_left_icon_url", "rij_multi_video_column_play");
      paramJSONObject.put("column_card_play_right_icon_url", "rij_multi_video_column_play");
    }
  }
  
  private void d(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    if (f.contains(Integer.valueOf(paramrpr.e)))
    {
      if ((!paramrpr.h.isEmpty()) && (!paramrpr.g.isEmpty()))
      {
        paramJSONObject.put("column_bottom_icon_view_visibility", "1");
        paramJSONObject.put("column_bottom_icon_url", paramrpr.h);
        paramJSONObject.put("column_bottom_name", paramrpr.g);
      }
    }
    else {
      return;
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "dataInfo's appIconUrl or appName is Empty.");
  }
  
  private void e(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    String str2 = "";
    String str3 = pkh.a(2131717631);
    String str1 = str2;
    if (paramrpr.jdField_c_of_type_Int > 0)
    {
      str1 = str2;
      if (!str3.isEmpty()) {
        str1 = String.format(str3, new Object[] { Integer.valueOf(paramrpr.jdField_c_of_type_Int) });
      }
    }
    if ((g.contains(Integer.valueOf(paramrpr.e))) && (!str1.isEmpty()))
    {
      if ((paramrpr.jdField_a_of_type_Boolean) && (f.contains(Integer.valueOf(paramrpr.e)))) {
        paramJSONObject.remove("column_bottom_video_count");
      }
    }
    else
    {
      str1 = pkh.a(2131717632);
      if ((!paramrpr.jdField_a_of_type_Boolean) || (paramrpr.jdField_b_of_type_Int == 0) || (str1.isEmpty())) {
        break label178;
      }
      paramJSONObject.put("column_bottom_video_update_count", String.format(str1, new Object[] { Integer.valueOf(paramrpr.jdField_b_of_type_Int) }));
    }
    label178:
    do
    {
      return;
      paramJSONObject.put("column_bottom_video_count", str1);
      break;
      paramrpr = a(paramrpr.jdField_a_of_type_Long, System.currentTimeMillis());
    } while (paramrpr.isEmpty());
    paramJSONObject.put("column_bottom_video_update_time", paramrpr);
  }
  
  private void f(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = paramrpr.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((rrv)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    paramJSONObject.put("rowkey", localJsonArray);
    paramJSONObject.put("column_id", paramrpr.jdField_a_of_type_Int);
    paramJSONObject.put("column_card_bg_style", paramrpr.e);
    if (paramrpr.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramJSONObject.put("subscribe_flag", i);
      return;
    }
  }
  
  private void g(JSONObject paramJSONObject, @NotNull rpr paramrpr)
  {
    if (h.contains(Integer.valueOf(paramrpr.e)))
    {
      paramJSONObject.put("column_top_view_visibility", "1");
      paramJSONObject.remove("column_middle_view_visibility");
    }
    while (c.contains(Integer.valueOf(paramrpr.e)))
    {
      paramJSONObject.put("column_card_show_video_title_visibility", "1");
      paramJSONObject.remove("column_card_not_show_video_title_visibility");
      return;
      paramJSONObject.put("column_middle_view_visibility", "1");
      paramJSONObject.remove("column_top_view_visibility");
    }
    paramJSONObject.put("column_card_not_show_video_title_visibility", "1");
    paramJSONObject.remove("column_card_show_video_title_visibility");
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.columnStyle != 1)) {
      return new JSONObject();
    }
    paramBaseArticleInfo = paramBaseArticleInfo.multiVideoColumnInfo;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.jdField_a_of_type_JavaUtilList == null) || (paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.size() < 2)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_Column_card_cell");
    a(paramBaseArticleInfo, localJSONObject);
    b(paramBaseArticleInfo, localJSONObject);
    d(localJSONObject, paramBaseArticleInfo);
    e(localJSONObject, paramBaseArticleInfo);
    f(localJSONObject, paramBaseArticleInfo);
    g(localJSONObject, paramBaseArticleInfo);
    QLog.d("ColumnTwoVideoInfo", 1, localJSONObject.toString());
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    rpr localrpr;
    do
    {
      return false;
      str = paramViewBase.getClickEvnet();
      paramqfw = paramqfw.a();
      localrpr = paramqfw.multiVideoColumnInfo;
      paramContainer = paramContainer.getContext();
      if ("cmd_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new qnk(this, paramContainer, localrpr, paramqfw));
        return true;
      }
      if ("cmd_column_left_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new qnl(this, paramContainer, localrpr, paramqfw));
        return true;
      }
      if ("cmd_column_right_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new qnm(this, paramContainer, localrpr, paramqfw));
        return true;
      }
    } while (!"cmd_subscription_click".equals(str));
    paramViewBase.setOnClickListener(new qnn(this, localrpr, paramqfw));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnj
 * JD-Core Version:    0.7.0.1
 */