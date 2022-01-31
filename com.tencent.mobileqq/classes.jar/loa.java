import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubscribeFragement;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;

public class loa
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public loa(ReadInJoySubscribeFragement paramReadInJoySubscribeFragement, Activity paramActivity, ListView paramListView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity.getApplicationContext(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    c();
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(paramString), 1));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramString = this.b;
    if (paramBoolean) {}
    for (;;)
    {
      paramString.setVisibility(i);
      QLog.d("ReadInJoySubscribeFragement", 2, "updateFriendBiuTips  uin : " + this.jdField_a_of_type_JavaLangString);
      return;
      i = 8;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969621, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367009));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367183));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131367184);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.f(ReadInJoySubscribeFragement.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySubscribeFragement)));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new lob(this));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a()
  {
    Object localObject = ((KandianMergeManager)ReadInJoySubscribeFragement.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySubscribeFragement).getManager(161)).a();
    if (localObject != null) {}
    for (localObject = ((KandianOx210MsgInfo.Biu0x210Msg)localObject).b + "";; localObject = null)
    {
      a((String)localObject, true);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    b(paramString, paramBoolean);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loa
 * JD-Core Version:    0.7.0.1
 */