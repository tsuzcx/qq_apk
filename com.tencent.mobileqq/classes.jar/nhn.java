import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.json.JSONException;

class nhn
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = aciy.a(8.0F, nhi.a(this.jdField_a_of_type_Nhi).getResources());
  
  private nhn(nhi paramnhi) {}
  
  private nhq a(int paramInt, View paramView)
  {
    if (paramView != null) {
      return (nhq)paramView.getTag();
    }
    paramView = new nhq(null);
    nhq.a(paramView, LayoutInflater.from(nhi.a(this.jdField_a_of_type_Nhi).getContext()).inflate(2131494364, null));
    nhq.a(paramView, (KanDianUrlRoundCornerImageView)nhq.a(paramView).findViewById(2131302789));
    nhq.a(paramView).setCorner(this.jdField_a_of_type_Int);
    nhq.a(paramView, (TextView)nhq.a(paramView).findViewById(2131312198));
    nhq.a(paramView, (ImageView)nhq.a(paramView).findViewById(2131302792));
    nhq.b(paramView, (ImageView)nhq.a(paramView).findViewById(2131302790));
    nhq.a(paramView).setTag(paramView);
    return paramView;
  }
  
  public int getCount()
  {
    return nhi.a(this.jdField_a_of_type_Nhi).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= nhi.a(this.jdField_a_of_type_Nhi).size()) {
      return null;
    }
    return nhi.a(this.jdField_a_of_type_Nhi).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof nhp)) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null)
    {
      aciy.a("getView", ajjy.a(2131639906), new NullPointerException());
      return paramView;
    }
    paramViewGroup = (TabChannelCoverInfo)paramViewGroup;
    int i = getItemViewType(paramInt);
    paramView = a(paramInt, paramView);
    switch (i)
    {
    }
    for (;;)
    {
      return nhq.a(paramView);
      try
      {
        URL localURL = new URL(paramViewGroup.mChannelCoverIcon);
        obj.a(nhq.a(paramView), localURL, nhi.a(this.jdField_a_of_type_Nhi).getContext());
        nhq.a(paramView).setText(paramViewGroup.mChannelCoverName);
        nhi.a(this.jdField_a_of_type_Nhi, paramViewGroup, nhq.a(paramView));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("IconTabController", 1, "", localMalformedURLException);
        }
      }
      nhq.a(paramView).setImageResource(2130848185);
      nhq.a(paramView).setText(ajjy.a(2131639905));
      if (nhi.a(this.jdField_a_of_type_Nhi).a()) {
        nhq.b(paramView).setVisibility(0);
      } else {
        nhq.b(paramView).setVisibility(8);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = getItem(paramInt);
    if (paramAdapterView == null)
    {
      aciy.a("IconTabController", ajjy.a(2131639907), new NullPointerException());
      return;
    }
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramAdapterView;
    int j = getItemViewType(paramInt);
    paramAdapterView = a(paramInt, paramView);
    switch (j)
    {
    default: 
      return;
    case 1: 
      j = nti.b;
      if (ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo) != -1) {}
      for (;;)
      {
        nti.a("0X8009496", localTabChannelCoverInfo, j, i, paramInt);
        nhi.a(this.jdField_a_of_type_Nhi).a(paramInt);
        this.jdField_a_of_type_Nhi.b();
        return;
        i = 0;
      }
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nhi.a(this.jdField_a_of_type_Nhi).b());
    PublicTransFragmentActivity.b(nhi.a(this.jdField_a_of_type_Nhi).getContext(), paramView, ReadInJoyChannelPanelFragment.class);
    for (;;)
    {
      try
      {
        paramView = new ocg().b().c(nhi.a(this.jdField_a_of_type_Nhi).a());
        if (!odi.a()) {
          continue;
        }
        paramInt = 1;
        ReadInJoyChannelPanelFragment.a("0X8009497", paramView.b("style", paramInt).a());
      }
      catch (JSONException paramView)
      {
        QLog.e("IconTabController", 1, QLog.getStackTraceString(paramView));
        continue;
      }
      nhi.a(this.jdField_a_of_type_Nhi).a(false);
      nhq.b(paramAdapterView).setVisibility(8);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhn
 * JD-Core Version:    0.7.0.1
 */