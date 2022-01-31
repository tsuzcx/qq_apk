package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalOneItem
  extends NetSearchTemplateHorizontalBaseItem
{
  public static final String k = NetSearchTemplateHorizontalOneItem.class.getSimpleName();
  public boolean b;
  public boolean c;
  public String l;
  public String m;
  public String n;
  
  protected NetSearchTemplateHorizontalOneItem(String paramString, long paramLong, List paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.n);
  }
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView)
  {
    if (!(paramNetSearchTemplateHorizontalBaseView instanceof NetSearchTemplateHorizontalOneView)) {
      return;
    }
    int i = paramNetSearchTemplateHorizontalBaseView.a().getLayoutParams().width - DisplayUtil.a(paramNetSearchTemplateHorizontalBaseView.a().getContext(), 7.0F);
    if (this.a != null) {
      SearchTemplatePresenter.a(this, paramNetSearchTemplateHorizontalBaseView, true, i);
    }
    if (TextUtils.isEmpty(this.l))
    {
      paramNetSearchTemplateHorizontalBaseView.e().setVisibility(8);
      if (!TextUtils.isEmpty(this.m)) {
        break label190;
      }
      paramNetSearchTemplateHorizontalBaseView.g().setVisibility(8);
      label85:
      if (!this.jdField_b_of_type_Boolean) {
        break label212;
      }
      paramNetSearchTemplateHorizontalBaseView.e().setGravity(1);
      paramNetSearchTemplateHorizontalBaseView.g().setGravity(1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.n)) {
        break label231;
      }
      paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(null);
      return;
      paramNetSearchTemplateHorizontalBaseView.e().setVisibility(0);
      if (this.c)
      {
        paramNetSearchTemplateHorizontalBaseView.e().setText(SearchUtils.a(paramNetSearchTemplateHorizontalBaseView.e(), i * 2, this.l, a(this.l), false));
        break;
      }
      paramNetSearchTemplateHorizontalBaseView.e().setText(this.l);
      break;
      label190:
      paramNetSearchTemplateHorizontalBaseView.g().setVisibility(0);
      paramNetSearchTemplateHorizontalBaseView.g().setText(this.m);
      break label85;
      label212:
      paramNetSearchTemplateHorizontalBaseView.e().setGravity(3);
      paramNetSearchTemplateHorizontalBaseView.g().setGravity(3);
    }
    label231:
    paramNetSearchTemplateHorizontalBaseView.a().setOnClickListener(this);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.l = paramJSONObject.optString("title");
    this.m = paramJSONObject.optString("desc");
    if (paramJSONObject.optInt("needCenter") == 1)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      this.n = paramJSONObject.optString("jumpUrl");
      if (paramJSONObject.optInt("highlightTitle", 1) != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      this.j = paramJSONObject.optString("result_id");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("extra_report_info");
      paramJSONObject = paramJSONObject.optJSONObject("imageInfo");
      if (paramJSONObject == null) {
        break label114;
      }
      a(paramJSONObject);
      return;
      bool1 = false;
      break;
    }
    label114:
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem
 * JD-Core Version:    0.7.0.1
 */