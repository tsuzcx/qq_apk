import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;

public class kko
  extends BaseAdapter
{
  public kko(TroopCardPopClassfic paramTroopCardPopClassfic) {}
  
  private void a(TroopCardPopClassfic.ViewHolder paramViewHolder, popclassifc.PopItem paramPopItem)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramPopItem.str_desc.get());
    int i = DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 48.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    paramPopItem = URLDrawable.getDrawable(paramPopItem.str_icon_url.get(), null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramPopItem);
    if ((paramPopItem != null) && (1 != paramPopItem.getStatus())) {
      paramPopItem.restartDownload();
    }
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard != null) {
      return ((popclassifc.PopCard)this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.get(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new TroopCardPopClassfic.ViewHolder();
      localView = LayoutInflater.from(this.a.getContext()).inflate(2130969419, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366430));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366429));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      a(paramViewGroup, localPopItem);
      localView.setOnClickListener(this.a);
      return localView;
      paramViewGroup = (TroopCardPopClassfic.ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kko
 * JD-Core Version:    0.7.0.1
 */