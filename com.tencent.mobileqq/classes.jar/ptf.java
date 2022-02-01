import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ptf
  implements View.OnClickListener, psw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private aoof jdField_a_of_type_Aoof;
  private blmm jdField_a_of_type_Blmm;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ppu jdField_a_of_type_Ppu;
  private sel jdField_a_of_type_Sel;
  private skg jdField_a_of_type_Skg;
  private boolean jdField_a_of_type_Boolean;
  
  public ptf(Context paramContext, aoof paramaoof, sel paramsel, ListView paramListView, blmm paramblmm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Sel = paramsel;
    this.jdField_a_of_type_Blmm = paramblmm;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = ozs.a((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private List<Long> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    label92:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ozs.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", ozs.e());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Ppu != null)
        {
          if (ubg.a(this.jdField_a_of_type_Ppu.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          ocd.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
        paramString = "0X800744D";
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private void a(skg paramskg, ppu paramppu, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      ppu localppu = (ppu)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381109);
      skg localskg = (skg)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381115);
      if ((localppu != null) && (localskg != null) && (paramppu.a().mGroupId == localppu.a().mGroupId))
      {
        localArrayList1.add(localskg);
        localArrayList2.add(localppu);
      }
      i += 1;
    }
    paramskg = new ptj(this, paramskg, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      paramppu = (Animation)((skg)localArrayList1.get(paramInt)).a().getTag(2131369503);
      if (paramInt != 0) {
        paramppu.setAnimationListener(null);
      }
      for (;;)
      {
        ((skg)localArrayList1.get(paramInt)).a().startAnimation(paramppu);
        paramInt += 1;
        break;
        paramppu.setAnimationListener(paramskg);
      }
    }
  }
  
  private void a(boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    int k = 8;
    int i;
    label90:
    label123:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = a(paramArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Skg.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
        int m = localObject1.length;
        i = 0;
        if (i >= m) {
          break label217;
        }
        localObject2 = localObject1[i];
        if (!paramBoolean) {
          break label210;
        }
      }
    }
    label205:
    label210:
    for (int j = 0;; j = 8)
    {
      localObject2.setVisibility(j);
      i += 1;
      break label123;
      this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Skg.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Skg.d.setVisibility(0);
      return;
      i = 8;
      continue;
      i = 0;
    }
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String c(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  public void a(skg paramskg, ppu paramppu)
  {
    paramskg = paramppu.a();
    paramppu = a(paramskg);
    int i = 0;
    if (i < Math.min(4, paramppu.size()))
    {
      if (ozs.a()) {
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(bcni.a(this.jdField_a_of_type_Aoof, String.valueOf(paramppu.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(paramppu.get(i));
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new pti(this, str, paramskg));
        i += 1;
        break;
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Sel.a(((Long)paramppu.get(i)).longValue()));
      }
    }
    i = Math.min(4, paramppu.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(skg paramskg, ppu paramppu, int paramInt)
  {
    this.jdField_a_of_type_Skg = paramskg;
    this.jdField_a_of_type_Ppu = paramppu;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Ppu.a();
    if (this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Skg.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Ppu.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Ppu.a())
      {
        this.jdField_a_of_type_Skg.a();
        if (this.jdField_a_of_type_Ppu.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Skg.f.setVisibility(8);
        if (this.jdField_a_of_type_Skg.g != null) {
          this.jdField_a_of_type_Skg.g.setVisibility(8);
        }
        this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Aoof);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramppu);
      }
      return;
    }
    this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Ppu.c())
    {
    default: 
      this.jdField_a_of_type_Skg.d.setOnClickListener(new ptg(this, paramppu, paramskg));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Skg.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        ozc.a(this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramskg, paramppu);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!ozs.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = bhlg.j((QQAppInterface)ozs.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Sel.b(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidWidgetTextView.setText(ozs.e((String)localObject));
      this.jdField_a_of_type_Skg.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(skg paramskg, ppu paramppu, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Ppu.c() == 3) {
      this.jdField_a_of_type_Skg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Skg.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Ppu.c() != 2) || (!ozs.a()));
      paramskg = a(paramppu.a());
    } while ((paramskg.size() <= 0) || (!paramskg.contains(Long.valueOf(paramLong))));
    int i = paramskg.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(ozs.d(this.jdField_a_of_type_Ppu.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = a(this.jdField_a_of_type_Ppu.a());
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = oyu.g + bhkv.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
          ozs.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        }
      }
      else
      {
        localObject = b(this.jdField_a_of_type_Ppu.a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ozs.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject = b(this.jdField_a_of_type_Ppu.a());
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              ozs.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
          else
          {
            localObject = a(this.jdField_a_of_type_Ppu.a());
            if (!((List)localObject).isEmpty())
            {
              localObject = oyu.g + bhkv.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
              ozs.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptf
 * JD-Core Version:    0.7.0.1
 */