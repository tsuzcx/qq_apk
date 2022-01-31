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

class nsx
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = actn.a(8.0F, nss.a(this.jdField_a_of_type_Nss).getResources());
  
  private nsx(nss paramnss) {}
  
  private nta a(int paramInt, View paramView)
  {
    if (paramView != null) {
      return (nta)paramView.getTag();
    }
    paramView = new nta(null);
    nta.a(paramView, LayoutInflater.from(nss.a(this.jdField_a_of_type_Nss).getContext()).inflate(2131559934, null));
    nta.a(paramView, (KanDianUrlRoundCornerImageView)nta.a(paramView).findViewById(2131368414));
    nta.a(paramView).setCorner(this.jdField_a_of_type_Int);
    nta.a(paramView, (TextView)nta.a(paramView).findViewById(2131378021));
    nta.a(paramView, (ImageView)nta.a(paramView).findViewById(2131368417));
    nta.b(paramView, (ImageView)nta.a(paramView).findViewById(2131368415));
    nta.a(paramView).setTag(paramView);
    return paramView;
  }
  
  public int getCount()
  {
    return nss.a(this.jdField_a_of_type_Nss).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= nss.a(this.jdField_a_of_type_Nss).size()) {
      return null;
    }
    return nss.a(this.jdField_a_of_type_Nss).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof nsz)) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null)
    {
      actn.a("getView", ajyc.a(2131705691), new NullPointerException());
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
      return nta.a(paramView);
      try
      {
        URL localURL = new URL(paramViewGroup.mChannelCoverIcon);
        omu.a(nta.a(paramView), localURL, nss.a(this.jdField_a_of_type_Nss).getContext());
        nta.a(paramView).setText(paramViewGroup.mChannelCoverName);
        nss.a(this.jdField_a_of_type_Nss, paramViewGroup, nta.a(paramView));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("IconTabController", 1, "", localMalformedURLException);
        }
      }
      nta.a(paramView).setImageResource(2130848415);
      nta.a(paramView).setText(ajyc.a(2131705690));
      if (nss.a(this.jdField_a_of_type_Nss).a()) {
        nta.b(paramView).setVisibility(0);
      } else {
        nta.b(paramView).setVisibility(8);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = getItem(paramInt);
    if (paramAdapterView == null)
    {
      actn.a("IconTabController", ajyc.a(2131705692), new NullPointerException());
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
      j = oes.b;
      if (ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo) != -1) {}
      for (;;)
      {
        oes.a("0X8009496", localTabChannelCoverInfo, j, i, paramInt);
        nss.a(this.jdField_a_of_type_Nss).a(paramInt);
        this.jdField_a_of_type_Nss.b();
        return;
        i = 0;
      }
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", nss.a(this.jdField_a_of_type_Nss).b());
    PublicTransFragmentActivity.b(nss.a(this.jdField_a_of_type_Nss).getContext(), paramView, ReadInJoyChannelPanelFragment.class);
    for (;;)
    {
      try
      {
        paramView = new onr().b().c(nss.a(this.jdField_a_of_type_Nss).a());
        if (!oot.a()) {
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
      nss.a(this.jdField_a_of_type_Nss).a(false);
      nta.b(paramAdapterView).setVisibility(8);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsx
 * JD-Core Version:    0.7.0.1
 */