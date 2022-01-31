package me.ele.uetool.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.ele.uetool.base.item.TitleItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$TitleViewHolder
  extends AttrsDialog.Adapter.BaseViewHolder<TitleItem>
{
  private TextView vTitle;
  
  public AttrsDialog$Adapter$TitleViewHolder(View paramView)
  {
    super(paramView);
    this.vTitle = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "title")));
  }
  
  public static TitleViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new TitleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_title"), paramViewGroup, false));
  }
  
  public void bindView(TitleItem paramTitleItem)
  {
    super.bindView(paramTitleItem);
    this.vTitle.setText(paramTitleItem.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */