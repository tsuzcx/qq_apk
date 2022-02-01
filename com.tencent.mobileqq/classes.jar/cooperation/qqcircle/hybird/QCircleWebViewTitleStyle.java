package cooperation.qqcircle.hybird;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

public class QCircleWebViewTitleStyle
  extends WebViewTitleStyle
{
  public static final Parcelable.Creator<QCircleWebViewTitleStyle> CREATOR = new QCircleWebViewTitleStyle.1();
  public int mLeftBackIcon;
  
  public QCircleWebViewTitleStyle() {}
  
  protected QCircleWebViewTitleStyle(Parcel paramParcel)
  {
    super(paramParcel);
    this.mLeftBackIcon = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mLeftBackIcon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hybird.QCircleWebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */