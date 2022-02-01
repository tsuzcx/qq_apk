import android.graphics.Color;
import android.os.Bundle;
import com.google.gson.JsonArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
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
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;

public class pvl
  implements pye
{
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet(Collections.singletonList(Integer.valueOf(4)));
  private static final Set<Integer> jdField_b_of_type_JavaUtilSet = new HashSet(Collections.singletonList(Integer.valueOf(1)));
  private static final Set<Integer> c = new HashSet(Collections.singletonList(Integer.valueOf(6)));
  private static final Set<Integer> d = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  private static final Set<Integer> e = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7) }));
  private static final Set<Integer> f = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> g = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> h = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
  private int jdField_a_of_type_Int;
  private NativeLayoutImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl;
  private NativeTextImp jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp;
  private rfm jdField_a_of_type_Rfm = new pvm(this);
  private NativeLayoutImpl jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl;
  private NativeTextImp jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp;
  
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
      str = ozs.g(2131717320);
      if (l >= 60000L) {
        break;
      }
      localObject = str;
    } while (!str.isEmpty());
    Object localObject = ozs.g(2131717321);
    if ((l < 3600000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L) });
    }
    localObject = ozs.g(2131717319);
    if ((l < 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L) });
    }
    localObject = ozs.g(2131717318);
    if ((l >= 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L / 24L) });
    }
    return "";
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int != paramInt) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp, paramBoolean);
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp, paramBoolean);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl, paramBoolean);
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl, paramBoolean);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo)
  {
    qwn localqwn = paramArticleInfo.multiVideoColumnInfo;
    HashMap localHashMap = new HashMap();
    localHashMap.put("feeds_type", Integer.valueOf(1050));
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = localqwn.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((qyq)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("rowkey", localJsonArray);
    localHashMap.put("column_id", Integer.valueOf(localqwn.jdField_a_of_type_Int));
    localHashMap.put("column_card_bg_style", Integer.valueOf(localqwn.e));
    if (localqwn.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("subscribe_flag", Integer.valueOf(i));
      sel.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
      return;
    }
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    qwn localqwn = paramArticleInfo.multiVideoColumnInfo;
    String str;
    HashMap localHashMap;
    if (paramBoolean)
    {
      str = "0x800A7FB";
      localHashMap = new HashMap();
      if (paramArticleInfo.mChannelID != 0L) {
        break label123;
      }
    }
    label123:
    for (int i = 1;; i = 2)
    {
      localHashMap.put("subscribe_page", Integer.valueOf(i));
      localHashMap.put("feeds_type", Integer.valueOf(1050));
      localHashMap.put("column_id", Integer.valueOf(localqwn.jdField_a_of_type_Int));
      localHashMap.put("column_card_bg_style", Integer.valueOf(localqwn.e));
      sel.a(paramArticleInfo, str, str, (int)paramArticleInfo.mChannelID, localHashMap);
      return;
      str = "0x800A7D3";
      break;
    }
  }
  
  private void a(@Nullable NativeLayoutImpl paramNativeLayoutImpl, boolean paramBoolean)
  {
    if (paramNativeLayoutImpl == null) {
      return;
    }
    if (paramBoolean)
    {
      paramNativeLayoutImpl.setBackgroundColor(Color.parseColor("#FFFFFF"));
      paramNativeLayoutImpl.setBorderColor(Color.parseColor("#E6E6E6"));
      paramNativeLayoutImpl.setBorderWidth(1);
    }
    for (;;)
    {
      paramNativeLayoutImpl.invalidate();
      return;
      paramNativeLayoutImpl.setBackgroundColor(Color.parseColor("#00CAFC"));
      paramNativeLayoutImpl.setBorderWidth(0);
    }
  }
  
  private void a(@Nullable NativeTextImp paramNativeTextImp, boolean paramBoolean)
  {
    if (paramNativeTextImp == null) {
      return;
    }
    if (paramBoolean)
    {
      paramNativeTextImp.setText(ozs.g(2131694700));
      paramNativeTextImp.setTextColor(Color.parseColor("#737373"));
    }
    for (;;)
    {
      paramNativeTextImp.invalidate();
      return;
      paramNativeTextImp.setText(ozs.g(2131694701));
      paramNativeTextImp.setTextColor(Color.parseColor("#FFFFFF"));
    }
  }
  
  private void a(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    String str = paramqwn.jdField_a_of_type_JavaLangString;
    if (str.isEmpty()) {
      QLog.e("ColumnTwoVideoProteusItem", 1, "column Name is empty.");
    }
    if ((jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramqwn.e))) && (!paramqwn.g.isEmpty()))
    {
      paramJSONObject.put("column_info_name_text", paramqwn.g + "·" + str);
      return;
    }
    paramJSONObject.put("column_info_name_text", str);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull qwn paramqwn, qyq paramqyq1, qyq paramqyq2)
  {
    if (c.contains(Integer.valueOf(paramqwn.e)))
    {
      if (paramqyq1.jdField_b_of_type_JavaLangString.isEmpty()) {
        break label65;
      }
      paramJSONObject.put("column_show_video_left_title", paramqyq1.jdField_b_of_type_JavaLangString);
    }
    while (!paramqyq2.jdField_b_of_type_JavaLangString.isEmpty())
    {
      paramJSONObject.put("column_show_video_right_title", paramqyq2.jdField_b_of_type_JavaLangString);
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
      paramJSONObject.put("subscribe_title", ozs.g(2131694700));
      paramJSONObject.put("subscription_title_color", "#737373");
      paramJSONObject.put("subscription_border_color", "#E6E6E6");
      paramJSONObject.put("subscription_border_width", "0.5");
      return;
    }
    paramJSONObject.put("subscription_background_color", "#00CAFC");
    paramJSONObject.put("subscribe_title", ozs.g(2131694701));
    paramJSONObject.put("subscription_title_color", "#FFFFFF");
    paramJSONObject.remove("subscription_border_color");
    paramJSONObject.remove("subscription_border_width");
  }
  
  private void a(qwn paramqwn, int paramInt)
  {
    QLog.d("ColumnTwoVideoProteusItem", 1, "requestSubscribeEvent, subscribeAction = " + paramInt);
    oidb_0xd4b.ReqBody localReqBody = new oidb_0xd4b.ReqBody();
    localReqBody.msg_subscribe_video_column_req.uint32_video_column_id.set(paramqwn.jdField_a_of_type_Int);
    localReqBody.msg_subscribe_video_column_req.uint32_oper_type.set(paramInt);
    localReqBody.msg_subscribe_video_column_req.setHasFlag(true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("subscribeAction", paramInt);
    localBundle.putString("columnIconUrl", paramqwn.jdField_b_of_type_JavaLangString);
    localBundle.putInt("columnId", paramqwn.jdField_a_of_type_Int);
    nkm.a(ozs.a(), new pvs(paramqwn, paramInt), localReqBody.toByteArray(), "OidbSvc.0xd4b", 3403, 1, localBundle);
  }
  
  private void a(qwn paramqwn, JSONObject paramJSONObject)
  {
    paramJSONObject.put("column_cover_image_url", paramqwn.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("column_logo_image_url", paramqwn.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramqwn);
    b(paramJSONObject, paramqwn);
    a(paramJSONObject, paramqwn.jdField_a_of_type_Boolean);
  }
  
  private void b(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    String str = ozs.g(2131717028);
    if ((jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramqwn.e))) && (paramqwn.d != 0) && (!str.isEmpty())) {
      paramJSONObject.put("column_info_subscription_text", String.format(str, new Object[] { bnrf.b(paramqwn.d) }));
    }
  }
  
  private void b(JSONObject paramJSONObject, @NotNull qwn paramqwn, qyq paramqyq1, qyq paramqyq2)
  {
    if (e.contains(Integer.valueOf(paramqwn.e)))
    {
      if (paramqyq1.jdField_b_of_type_Int == 0) {
        break label65;
      }
      paramJSONObject.put("column_card_play_left_time_text", bnrf.c(paramqyq1.jdField_b_of_type_Int));
    }
    while (paramqyq2.jdField_b_of_type_Int != 0)
    {
      paramJSONObject.put("column_card_play_right_time_text", bnrf.c(paramqyq2.jdField_b_of_type_Int));
      return;
      label65:
      QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's duration == 0.");
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's duration == 0.");
  }
  
  private void b(qwn paramqwn, JSONObject paramJSONObject)
  {
    qyq localqyq1 = (qyq)paramqwn.jdField_a_of_type_JavaUtilList.get(0);
    qyq localqyq2 = (qyq)paramqwn.jdField_a_of_type_JavaUtilList.get(1);
    paramJSONObject.put("column_left_item_cover_url", localqyq1.jdField_c_of_type_JavaLangString);
    paramJSONObject.put("column_right_item_cover_url", localqyq2.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramqwn, localqyq1, localqyq2);
    c(paramJSONObject, paramqwn);
    b(paramJSONObject, paramqwn, localqyq1, localqyq2);
  }
  
  private void c(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    if (d.contains(Integer.valueOf(paramqwn.e)))
    {
      paramJSONObject.put("column_card_play_left_icon_url", "rij_multi_video_column_play");
      paramJSONObject.put("column_card_play_right_icon_url", "rij_multi_video_column_play");
    }
  }
  
  private void d(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    if (f.contains(Integer.valueOf(paramqwn.e)))
    {
      if ((!paramqwn.h.isEmpty()) && (!paramqwn.g.isEmpty()))
      {
        paramJSONObject.put("column_bottom_icon_view_visibility", "1");
        paramJSONObject.put("column_bottom_icon_url", paramqwn.h);
        paramJSONObject.put("column_bottom_name", paramqwn.g);
      }
    }
    else {
      return;
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "dataInfo's appIconUrl or appName is Empty.");
  }
  
  private void e(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    String str2 = "";
    String str3 = ozs.g(2131717032);
    String str1 = str2;
    if (paramqwn.jdField_c_of_type_Int > 0)
    {
      str1 = str2;
      if (!str3.isEmpty()) {
        str1 = String.format(str3, new Object[] { Integer.valueOf(paramqwn.jdField_c_of_type_Int) });
      }
    }
    if ((g.contains(Integer.valueOf(paramqwn.e))) && (!str1.isEmpty()))
    {
      if ((paramqwn.jdField_a_of_type_Boolean) && (f.contains(Integer.valueOf(paramqwn.e)))) {
        paramJSONObject.remove("column_bottom_video_count");
      }
    }
    else
    {
      str1 = ozs.g(2131717033);
      if ((!paramqwn.jdField_a_of_type_Boolean) || (paramqwn.jdField_b_of_type_Int == 0) || (str1.isEmpty())) {
        break label178;
      }
      paramJSONObject.put("column_bottom_video_update_count", String.format(str1, new Object[] { Integer.valueOf(paramqwn.jdField_b_of_type_Int) }));
    }
    label178:
    do
    {
      return;
      paramJSONObject.put("column_bottom_video_count", str1);
      break;
      paramqwn = a(paramqwn.jdField_a_of_type_Long, System.currentTimeMillis());
    } while (paramqwn.isEmpty());
    paramJSONObject.put("column_bottom_video_update_time", paramqwn);
  }
  
  private void f(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = paramqwn.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((qyq)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    paramJSONObject.put("rowkey", localJsonArray);
    paramJSONObject.put("column_id", paramqwn.jdField_a_of_type_Int);
    paramJSONObject.put("column_card_bg_style", paramqwn.e);
    if (paramqwn.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramJSONObject.put("subscribe_flag", i);
      return;
    }
  }
  
  private void g(JSONObject paramJSONObject, @NotNull qwn paramqwn)
  {
    if (h.contains(Integer.valueOf(paramqwn.e)))
    {
      paramJSONObject.put("column_top_view_visibility", "1");
      paramJSONObject.remove("column_middle_view_visibility");
    }
    while (c.contains(Integer.valueOf(paramqwn.e)))
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
    this.jdField_a_of_type_Int = paramBaseArticleInfo.jdField_a_of_type_Int;
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
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    paramppu = paramppu.a();
    if ((paramppu == null) || (paramppu.multiVideoColumnInfo == null)) {
      return;
    }
    if (paramContainer.getTag(2131362206) == null)
    {
      paramContainer.setTag(2131362206, "true");
      paramContainer.addOnAttachStateChangeListener(new pvn(this));
    }
    paramContainer = paramContainer.getVirtualView();
    paramppu = paramContainer.findViewBaseByName("id_top_subscribe_view");
    if ((paramppu != null) && (paramppu.getNativeView() != null) && ((paramppu.getNativeView() instanceof NativeLayoutImpl))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl = ((NativeLayoutImpl)paramppu.getNativeView());
    }
    paramppu = paramContainer.findViewBaseByName("id_middle_subscribe_view");
    if ((paramppu != null) && (paramppu.getNativeView() != null) && ((paramppu.getNativeView() instanceof NativeLayoutImpl))) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperNativelayoutNativeLayoutImpl = ((NativeLayoutImpl)paramppu.getNativeView());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp = ((NativeTextImp)paramContainer.findViewBaseByName("id_top_subscribe_label").getNativeView());
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewTextNativeTextImp = ((NativeTextImp)paramContainer.findViewBaseByName("id_middle_subscribe_label").getNativeView());
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    qwn localqwn;
    do
    {
      return false;
      str = paramViewBase.getClickEvnet();
      paramppu = paramppu.a();
      localqwn = paramppu.multiVideoColumnInfo;
      paramContainer = paramContainer.getContext();
      if ("cmd_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new pvo(this, paramContainer, localqwn, paramppu));
        return true;
      }
      if ("cmd_column_left_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new pvp(this, paramContainer, localqwn, paramppu));
        return true;
      }
      if ("cmd_column_right_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new pvq(this, paramContainer, localqwn, paramppu));
        return true;
      }
    } while (!"cmd_subscription_click".equals(str));
    paramViewBase.setOnClickListener(new pvr(this, localqwn, paramppu));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvl
 * JD-Core Version:    0.7.0.1
 */