package me.ele.uetool.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;

public class MultipleAttrsDialog$BriefDescViewHolder
  extends MultipleAttrsDialog.Adapter.BaseViewHolder<BriefDescItem>
{
  private MultipleAttrsDialog.ValidCallBack callBack;
  private TextView vDesc;
  
  public MultipleAttrsDialog$BriefDescViewHolder(View paramView)
  {
    super(paramView);
    this.vDesc = ((TextView)paramView);
    this.vDesc.setOnClickListener(new MultipleAttrsDialog.BriefDescViewHolder.1(this));
  }
  
  public static BriefDescViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new BriefDescViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_brief_view_desc"), paramViewGroup, false));
  }
  
  public void bindView(BriefDescItem paramBriefDescItem)
  {
    super.bindView(paramBriefDescItem);
    Object localObject = paramBriefDescItem.getElement().getView();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject.getClass().getName());
    localObject = Util.getResourceName(((View)localObject).getId());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append("@").append((String)localObject);
    }
    this.vDesc.setText(localStringBuilder.toString());
    this.vDesc.setSelected(paramBriefDescItem.isSelected());
  }
  
  public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
  {
    this.callBack = paramValidCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.BriefDescViewHolder
 * JD-Core Version:    0.7.0.1
 */