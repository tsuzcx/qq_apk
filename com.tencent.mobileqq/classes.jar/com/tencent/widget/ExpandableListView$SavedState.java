package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import java.util.ArrayList;

public class ExpandableListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new ExpandableListView.SavedState.1();
  ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
  private Parcelable superState;
  
  private ExpandableListView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.superState = paramParcel.readParcelable(getClass().getClassLoader());
    this.expandedGroupMetadataList = new ArrayList();
    paramParcel.readList(this.expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
  }
  
  ExpandableListView$SavedState(Parcelable paramParcelable, ArrayList<ExpandableListConnector.GroupMetadata> paramArrayList)
  {
    super(EMPTY_STATE);
    this.expandedGroupMetadataList = paramArrayList;
    this.superState = paramParcelable;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.superState, paramInt);
    paramParcel.writeList(this.expandedGroupMetadataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView.SavedState
 * JD-Core Version:    0.7.0.1
 */