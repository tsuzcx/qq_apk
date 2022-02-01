package com.tencent.tkd.topicsdk.adapter.widget;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar$Status;", "", "(Ljava/lang/String;I)V", "UPLOADING", "PAUSE", "FAILED", "SUCCESS", "qq-adapter_release"}, k=1, mv={1, 1, 16})
 enum UploadVideoProgressBar$Status
{
  static
  {
    Status localStatus1 = new Status("UPLOADING", 0);
    UPLOADING = localStatus1;
    Status localStatus2 = new Status("PAUSE", 1);
    PAUSE = localStatus2;
    Status localStatus3 = new Status("FAILED", 2);
    FAILED = localStatus3;
    Status localStatus4 = new Status("SUCCESS", 3);
    SUCCESS = localStatus4;
    $VALUES = new Status[] { localStatus1, localStatus2, localStatus3, localStatus4 };
  }
  
  private UploadVideoProgressBar$Status() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar.Status
 * JD-Core Version:    0.7.0.1
 */