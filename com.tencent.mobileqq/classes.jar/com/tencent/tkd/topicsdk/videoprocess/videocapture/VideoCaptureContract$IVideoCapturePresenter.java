package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import com.tencent.tkd.topicsdk.mvp.BasePresenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCapturePresenter;", "Lcom/tencent/tkd/topicsdk/mvp/BasePresenter;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CapturePreparedListener;", "confirmClick", "", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "expandCandidateImageList", "position", "", "seedPosition", "loadPreviewListCapture", "recoveryCandidateImageList", "seekCandidateImage", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface VideoCaptureContract$IVideoCapturePresenter
  extends BasePresenter<VideoCaptureContract.IVideoCaptureView>, CapturePreparedListener
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureContract.IVideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */