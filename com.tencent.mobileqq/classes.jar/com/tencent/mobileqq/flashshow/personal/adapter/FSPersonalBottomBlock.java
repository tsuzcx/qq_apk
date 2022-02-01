package com.tencent.mobileqq.flashshow.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalTab;
import com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget;
import com.tencent.mobileqq.flashshow.widgets.FSBaseSingleViewBlock;
import java.util.ArrayList;

public class FSPersonalBottomBlock
  extends FSBaseSingleViewBlock
{
  private FSPersonalBottomWidget a;
  private ArrayList<FSPersonalTab> b;
  private String c;
  
  public FSPersonalBottomBlock(Bundle paramBundle)
  {
    super(paramBundle);
    this.c = paramBundle.getString("fs_key_bundle_personal_user_uin");
  }
  
  protected BaseWidgetView<ArrayList<FSPersonalTab>> a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new FSPersonalBottomWidget(paramViewGroup.getContext(), this.c);
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      this.a.setData(paramViewGroup);
    }
    return this.a;
  }
  
  public void a(ArrayList<FSPersonalTab> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.equals(this.b)) {
        return;
      }
      this.b = paramArrayList;
      paramArrayList = this.a;
      if (paramArrayList != null) {
        paramArrayList.setData(this.b);
      }
    }
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalBottomBlock
 * JD-Core Version:    0.7.0.1
 */