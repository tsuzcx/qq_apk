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

class nsu
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = actj.a(8.0F, nsp.a(this.jdField_a_of_type_Nsp).getResources());
  
  private nsu(nsp paramnsp) {}
  
  private nsx a(int paramInt, View paramView)
  {
    if (paramView != null) {
      return (nsx)paramView.getTag();
    }
    paramView = new nsx(null);
    nsx.a(paramView, LayoutInflater.from(nsp.a(this.jdField_a_of_type_Nsp).getContext()).inflate(2131559934, null));
    nsx.a(paramView, (KanDianUrlRoundCornerImageView)nsx.a(paramView).findViewById(2131368414));
    nsx.a(paramView).setCorner(this.jdField_a_of_type_Int);
    nsx.a(paramView, (TextView)nsx.a(paramView).findViewById(2131378026));
    nsx.a(paramView, (ImageView)nsx.a(paramView).findViewById(2131368417));
    nsx.b(paramView, (ImageView)nsx.a(paramView).findViewById(2131368415));
    nsx.a(paramView).setTag(paramView);
    return paramView;
  }
  
  public int getCount()
  {
    return nsp.a(this.jdField_a_of_type_Nsp).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= nsp.a(this.jdField_a_of_type_Nsp).size()) {
      return null;
    }
    return nsp.a(this.jdField_a_of_type_Nsp).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof nsw)) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null)
    {
      actj.a("getView", ajya.a(2131705702), new NullPointerException());
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
      return nsx.a(paramView);
      try
      {
        URL localURL = new URL(paramViewGroup.mChannelCoverIcon);
        omr.a(nsx.a(paramView), localURL, nsp.a(this.jdField_a_of_type_Nsp).getContext());
        nsx.a(paramView).setText(paramViewGroup.mChannelCoverName);
        nsp.a(this.jdField_a_of_type_Nsp, paramViewGroup, nsx.a(paramView));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("IconTabController", 1, "", localMalformedURLException);
        }
      }
      nsx.a(paramView).setImageResource(2130848421);
      nsx.a(paramView).setText(ajya.a(2131705701));
      if (nsp.a(this.jdField_a_of_type_Nsp).a()) {
        nsx.b(paramView).setVisibility(0);
      } else {
        nsx.b(paramView).setVisibility(8);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = getItem(paramInt);
    if (paramAdapterView == null)
    {
      actj.a("IconTabController", ajya.a(2131705703), new NullPointerException());
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
      j = oep.b;
      if (ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo) != -1) {}
      for (;;)
      {
        oep.a("0X8009496", localTabChannelCoverInfo, j, i, paramInt);
        nsp.a(this.jdField_a_of_type_Nsp).a(paramInt);
        this.jdField_a_of_type_Nsp.b();
        return;
        i = 0;
      }
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nsp.a(this.jdField_a_of_type_Nsp).b());
    PublicTransFragmentActivity.b(nsp.a(this.jdField_a_of_type_Nsp).getContext(), paramView, ReadInJoyChannelPanelFragment.class);
    for (;;)
    {
      try
      {
        paramView = new ono().b().c(nsp.a(this.jdField_a_of_type_Nsp).a());
        if (!ooq.a()) {
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
      nsp.a(this.jdField_a_of_type_Nsp).a(false);
      nsx.b(paramAdapterView).setVisibility(8);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */