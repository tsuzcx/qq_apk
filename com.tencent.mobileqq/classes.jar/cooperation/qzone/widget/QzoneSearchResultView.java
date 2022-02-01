package cooperation.qzone.widget;

import amsw;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bfvo;
import bfzl;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.List;

public class QzoneSearchResultView
  extends LinearLayout
{
  public static final String HAS_VIDEO = "1";
  public static final int MAX_LENGTH_TITLE = 18;
  public ImageView avartaView;
  public QzoneImagesContainer container;
  public TextView firstNameView;
  public TextView publishTimeView;
  private AccountSearchPb.ResultItem resultItem;
  public TextView summaryView;
  public TextView titleView;
  
  public QzoneSearchResultView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneSearchResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void jumpMoreFeeds(FragmentActivity paramFragmentActivity, String paramString)
  {
    QZoneHelper.forwardToBrowser(paramFragmentActivity, paramString, -1, null, null);
  }
  
  public void bindData(QQAppInterface paramQQAppInterface, SearchBaseFragment paramSearchBaseFragment, AccountSearchPb.ResultItem paramResultItem)
  {
    if ((paramResultItem == null) || (paramSearchBaseFragment == null) || (paramQQAppInterface == null))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.resultItem = paramResultItem;
    Object localObject1 = ((amsw)paramQQAppInterface.getManager(51)).e(getUin());
    paramQQAppInterface = "";
    if (localObject1 != null) {
      paramQQAppInterface = ((Friends)localObject1).name;
    }
    Object localObject3 = paramResultItem.nick_name.get().toStringUtf8();
    Object localObject2 = paramResultItem.name.get().toStringUtf8();
    String str = paramResultItem.summary.get().toStringUtf8();
    localObject1 = paramResultItem.pic_url_list.get();
    int i = paramResultItem.total_pic_num.get();
    long l = paramResultItem.ftime.get();
    CharSequence localCharSequence = bfzl.a(getContext(), 3, 1000L * l, false);
    localObject3 = paramSearchBaseFragment.a(80000004, (String)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      this.firstNameView.setText((CharSequence)localObject3);
      if (l <= 0L) {
        break label324;
      }
      this.publishTimeView.setText(localCharSequence);
      label185:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, (String)localObject2);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label336;
      }
      this.titleView.setVisibility(8);
      this.summaryView.setMaxLines(2);
      this.summaryView.setEllipsize(TextUtils.TruncateAt.END);
      label228:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, str);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label397;
      }
      this.summaryView.setVisibility(8);
    }
    for (;;)
    {
      boolean bool = "1".equals(paramResultItem.has_video.get().toStringUtf8());
      this.container.setImages((List)localObject1, i, bool);
      return;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramSearchBaseFragment.a(80000004, paramQQAppInterface);
        this.firstNameView.setText(paramQQAppInterface);
        break;
      }
      this.firstNameView.setText(getUin());
      break;
      label324:
      this.publishTimeView.setVisibility(8);
      break label185;
      label336:
      this.titleView.setVisibility(0);
      localObject2 = new SpannableStringBuilder("《");
      ((SpannableStringBuilder)localObject2).append(paramQQAppInterface).append("》");
      this.titleView.setText((CharSequence)localObject2);
      this.summaryView.setMaxLines(1);
      this.summaryView.setEllipsize(TextUtils.TruncateAt.END);
      break label228;
      label397:
      this.summaryView.setText(paramQQAppInterface);
    }
  }
  
  public void doClick(FragmentActivity paramFragmentActivity)
  {
    QZoneHelper.forwardToDetail(paramFragmentActivity, QZoneHelper.UserInfo.getInstance(), this.resultItem.jmp_url.get().toStringUtf8(), -1);
  }
  
  public String getUin()
  {
    return String.valueOf(this.resultItem.uin.get());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.avartaView = ((ImageView)findViewById(2131367958));
    this.firstNameView = ((TextView)findViewById(2131366723));
    this.publishTimeView = ((TextView)findViewById(2131373160));
    this.titleView = ((TextView)findViewById(2131378707));
    this.summaryView = ((TextView)findViewById(2131378011));
    this.container = ((QzoneImagesContainer)findViewById(2131368414));
  }
  
  public void setAvartaView(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.avartaView.setVisibility(0);
      this.avartaView.setImageBitmap(paramBitmap);
      return;
    }
    this.avartaView.setVisibility(0);
    this.avartaView.setImageBitmap(bfvo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneSearchResultView
 * JD-Core Version:    0.7.0.1
 */