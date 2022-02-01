import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class mzb
  extends mzg<myx>
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView.LayoutParams jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public mzb(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams = ((RecyclerView.LayoutParams)paramView.getLayoutParams());
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width;
    this.c = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363198));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363195));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363194);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363196));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363192));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363191));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363193));
    paramView.setOnTouchListener(new mzc(this));
  }
  
  public void a(mzj parammzj, myx parammyx, int paramInt)
  {
    super.a(parammzj, parammyx, paramInt);
    if (parammyx == null) {
      return;
    }
    if ((parammyx.a()) && (!myx.b()))
    {
      this.itemView.setVisibility(8);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = 0;
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = 0;
      return;
    }
    this.itemView.setVisibility(0);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = this.c;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(parammyx.b());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parammyx.b());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(parammyx.c());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(parammyx.c());
    if (parammyx.a())
    {
      FaceDecoder localFaceDecoder = null;
      if ((parammzj instanceof mzd)) {
        localFaceDecoder = ((mzd)parammzj).a();
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.a(17, 17, parammyx.a(), localFaceDecoder);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.itemView.getContext().getString(2131690336, new Object[] { Integer.valueOf(parammyx.d()) }));
      if (parammyx.d() > 0)
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
 * Qualified Name:     mzb
 * JD-Core Version:    0.7.0.1
 */