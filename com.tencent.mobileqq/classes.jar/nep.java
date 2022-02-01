import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class nep
  extends new<nej>
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView.LayoutParams jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public nep(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams = ((RecyclerView.LayoutParams)paramView.getLayoutParams());
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width;
    this.c = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363217));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363214));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363213);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363215));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363211));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363210));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363212));
    paramView.setOnTouchListener(new neq(this));
    a(paramView);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramAppInterface);
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(nfa paramnfa, nej paramnej, int paramInt)
  {
    super.a(paramnfa, paramnej, paramInt);
    if (paramnej == null) {
      return;
    }
    if ((paramnej.a()) && (!nej.b()))
    {
      this.itemView.setVisibility(8);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = 0;
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = 0;
      return;
    }
    this.itemView.setVisibility(0);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = this.c;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramnej.b());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramnej.b());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramnej.c());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramnej.c());
    if (paramnej.a())
    {
      if ((paramnfa instanceof neu)) {
        a(((neu)paramnfa).a());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.a(17, 17, paramnej.a(), this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.itemView.getContext().getString(2131690375, new Object[] { Integer.valueOf(paramnej.d()) }));
      if (paramnej.d() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nep
 * JD-Core Version:    0.7.0.1
 */