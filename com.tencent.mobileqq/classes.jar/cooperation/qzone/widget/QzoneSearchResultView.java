package cooperation.qzone.widget;

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
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.List;

public class QzoneSearchResultView
  extends LinearLayout
{
  public ImageView a;
  public TextView a;
  private AccountSearchPb.ResultItem a;
  public QzoneImagesContainer a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public QzoneSearchResultView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneSearchResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, String paramString)
  {
    QZoneHelper.a(paramFragmentActivity, paramString, -1, null, null);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem.uin.get());
  }
  
  public void a(FragmentActivity paramFragmentActivity)
  {
    QZoneHelper.a(paramFragmentActivity, QZoneHelper.UserInfo.a(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem.jmp_url.get().toStringUtf8(), -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SearchBaseFragment paramSearchBaseFragment, AccountSearchPb.ResultItem paramResultItem)
  {
    if ((paramResultItem == null) || (paramSearchBaseFragment == null) || (paramQQAppInterface == null))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = paramResultItem;
    Object localObject1 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(a());
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
    CharSequence localCharSequence = TimeFormatterUtils.a(getContext(), 3, 1000L * l, false);
    localObject3 = paramSearchBaseFragment.a(80000004, (String)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      if (l <= 0L) {
        break label324;
      }
      this.b.setText(localCharSequence);
      label185:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, (String)localObject2);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label336;
      }
      this.c.setVisibility(8);
      this.d.setMaxLines(2);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      label228:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, str);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label397;
      }
      this.d.setVisibility(8);
    }
    for (;;)
    {
      boolean bool = "1".equals(paramResultItem.has_video.get().toStringUtf8());
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneImagesContainer.setImages((List)localObject1, i, bool);
      return;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramSearchBaseFragment.a(80000004, paramQQAppInterface);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQAppInterface);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
      break;
      label324:
      this.b.setVisibility(8);
      break label185;
      label336:
      this.c.setVisibility(0);
      localObject2 = new SpannableStringBuilder("《");
      ((SpannableStringBuilder)localObject2).append(paramQQAppInterface).append("》");
      this.c.setText((CharSequence)localObject2);
      this.d.setMaxLines(1);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      break label228;
      label397:
      this.d.setText(paramQQAppInterface);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362851));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369358));
    this.b = ((TextView)findViewById(2131374142));
    this.c = ((TextView)findViewById(2131363360));
    this.d = ((TextView)findViewById(2131363509));
    this.jdField_a_of_type_CooperationQzoneWidgetQzoneImagesContainer = ((QzoneImagesContainer)findViewById(2131366928));
  }
  
  public void setAvartaView(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneSearchResultView
 * JD-Core Version:    0.7.0.1
 */